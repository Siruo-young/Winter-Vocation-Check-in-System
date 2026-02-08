package com.example.winter_vacation_checkin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.winter_vacation_checkin.domain.LaActivity;
import com.example.winter_vacation_checkin.domain.LaActivityTaskRelation;
import com.example.winter_vacation_checkin.mapper.LaActivityMapper;
import com.example.winter_vacation_checkin.mapper.LaActivityTaskRelationMapper;
import com.example.winter_vacation_checkin.mapper.LaAwardMapper;
import com.example.winter_vacation_checkin.mapper.LaUserJoinMapper;
import com.example.winter_vacation_checkin.reponse.PageResult;
import com.example.winter_vacation_checkin.service.LaActivityService;
import com.example.winter_vacation_checkin.util.SnowFlakeUtil;
import com.example.winter_vacation_checkin.vo.ActivityAddandUpdate;
import com.example.winter_vacation_checkin.vo.ActivityDetailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author 徐扬
* @description 针对表【la_activity】的数据库操作Service实现
* @createDate 2026-02-04 16:16:45
*/
@Service
@Transactional
public class LaActivityServiceImpl extends ServiceImpl<LaActivityMapper, LaActivity>
    implements LaActivityService{
    @Resource
    private LaActivityTaskRelationMapper laActivityTaskRelationMapper;

    @Resource
    private LaUserJoinMapper laUserJoinMapper;

    @Resource
    private LaAwardMapper laAwardMapper;

    @Override
    //出现异常就回滚
    @Transactional(rollbackFor = Exception.class)
    public Boolean add(ActivityAddandUpdate activityAddandUpdate) {
        LaActivity laActivity = new LaActivity();
        BeanUtils.copyProperties(activityAddandUpdate,laActivity);
        laActivity.setId(SnowFlakeUtil.getDefaultSnowFlakeId());
        laActivity.setCreateTime(new Date());
        laActivity.setUpdateTime(new Date());
        laActivity.setIsDelete(0);
        baseMapper.insert(laActivity);
        //插入关联表la_activity_task_relation
        for (Long along:activityAddandUpdate.getTaskIdList()) {
            LaActivityTaskRelation laActivityTaskRelation = new LaActivityTaskRelation();
            /*//构造查询条件
            QueryWrapper<LaActivityTaskRelation> wrapper = new QueryWrapper<LaActivityTaskRelation>()
                    .eq("task_id",along)
                    .eq("activity_id",laActivity.getId());
            //该条记录是否曾经存在
            LaActivityTaskRelation one = laActivityTaskRelationMapper.selectOne(wrapper);
            if(one != null){
                one.setIsDelete(0);
                one.setUpdateTime(new Date());
                laActivityTaskRelationMapper.updateById(one);
            }*/
            laActivityTaskRelation.setId(SnowFlakeUtil.getDefaultSnowFlakeId());
            laActivityTaskRelation.setActivityId(laActivity.getId());
            laActivityTaskRelation.setTaskId(along);
            laActivityTaskRelation.setCreateTime(new Date());
            laActivityTaskRelation.setUpdateTime(new Date());
            laActivityTaskRelation.setIsDelete(0);
            laActivityTaskRelationMapper.insert(laActivityTaskRelation);
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean edit(ActivityAddandUpdate activityAddandUpdate) {
        //本来想类比taskIdList,实在很难实现
        //可以把原来的la_activity_task_relation关于该活动的数据全部删除，然后再重新新建
        LaActivity laActivity = new LaActivity();
        BeanUtils.copyProperties(activityAddandUpdate,laActivity);
        laActivity.setUpdateTime(new Date());
        //删除旧的activity-task关系
        laActivityTaskRelationMapper.updateByActivityId(laActivity.getId());
        //建立新的activity-task关系
        //插入关联表la_activity_task_relation
        for (Long along:activityAddandUpdate.getTaskIdList()) {
            LaActivityTaskRelation laActivityTaskRelation = new LaActivityTaskRelation();
            laActivityTaskRelation.setId(SnowFlakeUtil.getDefaultSnowFlakeId());
            laActivityTaskRelation.setActivityId(laActivity.getId());
            laActivityTaskRelation.setTaskId(along);
            laActivityTaskRelation.setCreateTime(new Date());
            laActivityTaskRelation.setUpdateTime(new Date());
            laActivityTaskRelation.setIsDelete(0);
            laActivityTaskRelationMapper.insert(laActivityTaskRelation);
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(Long id) {
        //判断有没有人报名
        Long byActivityId = laUserJoinMapper.getByActivityId(id);
        if(byActivityId > 0){
            return false;
        }
        baseMapper.deleteById(id);
        //删除activity-task关系的数据
        laActivityTaskRelationMapper.updateByActivityId(id);
        //删除activity-award关系
        laAwardMapper.updateByActivityId(id);
        return true;
    }

    @Override
    public PageResult<ActivityDetailVo> getByNameTypePage(Integer pageNum, Integer pageSize, String name, Integer type) {
        Page<ActivityDetailVo> page = new Page<>(pageNum,pageSize);
        if (StringUtils.isEmpty(name)){
            name = null;
        }
        IPage<ActivityDetailVo> list = baseMapper.getByNameTypePage(page,name, type);
        return PageResult.iPageHandle(list.getTotal(),list.getCurrent(),list.getSize(),list.getRecords());

    }
}




