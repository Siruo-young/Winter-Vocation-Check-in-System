package com.example.winter_vacation_checkin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.winter_vacation_checkin.domain.*;
import com.example.winter_vacation_checkin.mapper.*;
import com.example.winter_vacation_checkin.reponse.PageResult;
import com.example.winter_vacation_checkin.service.LaAwardService;
import com.example.winter_vacation_checkin.service.LaUserJoinService;
import com.example.winter_vacation_checkin.util.SnowFlakeUtil;
import com.example.winter_vacation_checkin.vo.UserActivityListVo;
import com.example.winter_vacation_checkin.vo.UserCheckinDaysVo;
import com.example.winter_vacation_checkin.vo.UserCheckinDetailVo;
import lombok.Data;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
* @author 徐扬
* @description 针对表【la_user_join】的数据库操作Service实现
* @createDate 2026-02-04 16:16:44
*/
@Service
public class LaUserJoinServiceImpl extends ServiceImpl<LaUserJoinMapper, LaUserJoin>
    implements LaUserJoinService{

    @Resource
    private LaUserTaskRecordMapper laUserTaskRecordMapper;

    @Resource
    private LaActivityMapper laActivityMapper;

    @Resource
    private LaActivityTaskRelationMapper laActivityTaskRelationMapper;

    @Resource
    private LaTaskMapper laTaskMapper;

    @Resource
    private LaAwardMapper laAwardMapper;

    @Resource
    private LaUserAwardRecordMapper laUserAwardRecordMapper;

    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Override
    public PageResult<UserActivityListVo> getUserJoinByNameTypePage(Integer pageNum, Integer pageSize, String name, Integer status) {
        Page<UserActivityListVo> page = new Page<>(pageNum,pageSize);
        if (StringUtils.isEmpty(name)){
            name = null;
        }
        IPage<UserActivityListVo> list = baseMapper.getUserJoinByNameTypePage(page,name, status);
        return PageResult.iPageHandle(list.getTotal(),list.getCurrent(),list.getSize(),list.getRecords());

    }

    @Override
    public Boolean userJoin(Long userId, Long activityId) {
        LaUserJoin laUserJoin = new LaUserJoin();
        laUserJoin.setUserId(userId);
        laUserJoin.setActivityId(activityId);
        laUserJoin.setCreateTime(new Date());
        laUserJoin.setUpdateTime(new Date());
        laUserJoin.setCreateUser(userId);
        laUserJoin.setUpdateUser(userId);
        laUserJoin.setIsDelete(0);
        int insert = baseMapper.insert(laUserJoin);
        return insert > 0;
    }

    @Override
    public UserCheckinDaysVo getSignDays(Long userId, Long activityId) {
        List<LaUserTaskRecord> taskRecordList = laUserTaskRecordMapper.getByUserIdandActivityId(userId,activityId);
        UserCheckinDaysVo vo = new UserCheckinDaysVo();

        //查询出所有未完成的任务，获取第一个任务get(0)
        Long laTaskId = laActivityTaskRelationMapper.getLastTask(userId,activityId);
        vo.setTask(laTaskMapper.selectById(laTaskId));

        vo.setTotalDays(taskRecordList.size());
        vo.setTaskRecordList(taskRecordList);
        LaActivity laActivity = laActivityMapper.selectById(activityId);
        vo.setStartTime(laActivity.getStartTime());
        vo.setEndTime(laActivity.getEndTime());
        //连续打卡天数
        String s = redisTemplate.opsForValue().get(userId + activityId);
        if(s == null){
            vo.setContinueNum(0);
        }else {
            vo.setContinueNum(Integer.parseInt(s));
        }
        return vo;
    }

    @Override
    public UserCheckinDetailVo sign(Long userId, Long activityId, Long taskId) {
        LaUserTaskRecord laUserTaskRecord = new LaUserTaskRecord();
        laUserTaskRecord.setId(SnowFlakeUtil.getDefaultSnowFlakeId());
        laUserTaskRecord.setActivityId(activityId);
        laUserTaskRecord.setTaskId(taskId);
        laUserTaskRecord.setUserId(userId);
        laUserTaskRecord.setCreateTime(new Date());
        laUserTaskRecord.setUpdateTime(new Date());
        laUserTaskRecord.setCreateUser(userId);
        laUserTaskRecord.setUpdateUser(userId);
        laUserTaskRecord.setIsDelete(0);
        //插入la_user_task_record
        laUserTaskRecordMapper.insert(laUserTaskRecord);

        //设置连续打卡天数
        String continueNum = redisTemplate.opsForValue().get(userId + activityId);
        if (continueNum == null){
            //打卡间断或第一次打卡
            redisTemplate.opsForValue().set((userId + activityId + ""),1 + "");
        }else {
            //连续打卡
            redisTemplate.opsForValue().set((userId + activityId + ""), Integer.parseInt(continueNum) + 1 + "");
        }
        //当前时间
        LocalDateTime now = LocalDateTime.now();
        //过期时间
        LocalDateTime expireTime = LocalDateTime.of(
                now.toLocalDate().plusDays(1),
                LocalTime.of(23, 59, 59)
        );
        //当前时间与过期时间间隔
        long expireSeconds = Duration.between(now, expireTime).getSeconds();
        //设置过期时间，为明晚23：59：59
        redisTemplate.expire((userId + activityId + ""),expireSeconds, TimeUnit.SECONDS);


        UserCheckinDetailVo vo = new UserCheckinDetailVo();
        //是否获奖，是否完成任务
        //已做完任务数
        Long completedTaskRecordCounts = laUserTaskRecordMapper.taskCount(userId,activityId);
        //总任务数
        Long totalTaskRecordCounts = laUserTaskRecordMapper.totalTaskCount(activityId);
        //用户任务全部做完
        if (completedTaskRecordCounts.equals(totalTaskRecordCounts)){
            LaAward laAward = laAwardMapper.getByActivityId(activityId);
            if(laAward.getIsLimit() == 1){
                //不限制数量
                vo.setAward(laAward);
            }else {
                //限制数量 加分布式锁
                try {
                    Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent(laAward.getId().toString(), UUID.randomUUID().toString());
                    if (aBoolean){
                        redisTemplate.expire(laAward.getId().toString(),1, TimeUnit.SECONDS);
                        laAward.setNum(laAward.getNum() - 1);
                        vo.setAward(laAward);
                        //la_award更新数据
                        laAwardMapper.updateById(laAward);
                        //la_user_award_record插入数据
                        LaUserAwardRecord laUserAwardRecord = new LaUserAwardRecord();
                        laUserAwardRecord.setId(SnowFlakeUtil.getDefaultSnowFlakeId());
                        laUserAwardRecord.setUserId(userId);
                        laUserAwardRecord.setActivityId(activityId);
                        laUserAwardRecord.setNum(1);
                        laUserAwardRecord.setAwardId(laAward.getId());
                        laUserAwardRecord.setCreateUser(userId);
                        laUserAwardRecord.setUpdateUser(userId);
                        laUserAwardRecord.setCreateTime(new Date());
                        laUserAwardRecord.setUpdateTime(new Date());
                        laUserAwardRecord.setIsDelete(0);
                        laUserAwardRecordMapper.insert(laUserAwardRecord);
                    }
                } catch (Exception e) {
                    log.error("加锁失败");
                }
            }
        vo.setIsAwarded(true);

        }
        vo.setIsAwarded(false);
        vo.setIsSuccess(true);
        return vo;
    }

}




