package com.example.winter_vacation_checkin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.winter_vacation_checkin.domain.LaActivityTaskRelation;
import com.example.winter_vacation_checkin.domain.LaTask;
import com.example.winter_vacation_checkin.mapper.LaActivityTaskRelationMapper;
import com.example.winter_vacation_checkin.reponse.PageResult;
import com.example.winter_vacation_checkin.service.LaActivityTaskRelationService;
import com.example.winter_vacation_checkin.service.LaTaskService;
import com.example.winter_vacation_checkin.mapper.LaTaskMapper;
import com.example.winter_vacation_checkin.util.SnowFlakeUtil;
import com.example.winter_vacation_checkin.vo.ActivityDetailVo;
import com.example.winter_vacation_checkin.vo.TaskAddandUpdateVo;
import com.example.winter_vacation_checkin.vo.TaskDetailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author 徐扬
* @description 针对表【la_task】的数据库操作Service实现
* @createDate 2026-02-04 16:16:45
*/
@Service
public class LaTaskServiceImpl extends ServiceImpl<LaTaskMapper, LaTask>
    implements LaTaskService{
    @Resource
    private LaActivityTaskRelationMapper laActivityTaskRelationMapper;

    @Override
    public Boolean add(TaskAddandUpdateVo taskAddandUpdateVo) {
        LaTask laTask = new LaTask();
        BeanUtils.copyProperties(taskAddandUpdateVo,laTask);
        laTask.setId(SnowFlakeUtil.getDefaultSnowFlakeId());
        laTask.setCreateTime(new Date());
        laTask.setUpdateTime(new Date());
        laTask.setIsDelete(0);
        int insert = baseMapper.insert(laTask);
        return insert > 0;
    }

    @Override
    public Boolean edit(TaskAddandUpdateVo taskAddandUpdateVo) {
        LaTask laTask = new LaTask();
        BeanUtils.copyProperties(taskAddandUpdateVo,laTask);
        laTask.setUpdateTime(new Date());
        int update = baseMapper.updateById(laTask);
        return update > 0;
    }

    @Override
    public Boolean delete(Long id) {
        //判断是否有活动关联该任务
        Long taskIdNum = laActivityTaskRelationMapper.selectCount(new QueryWrapper<LaActivityTaskRelation>().eq("task_id", id));
        if (taskIdNum > 0){
            return false;
        }
        baseMapper.delById(id);
        return true;
    }

    @Override
    public PageResult<TaskDetailVo> listTask(Integer pageNum, Integer pageSize, String name, Integer type) {
        Page<TaskDetailVo> page = new Page<>(pageNum,pageSize);
        if (StringUtils.isEmpty(name)){
            name = null;
        }
        IPage<TaskDetailVo> list = baseMapper.listTask(page,name, type);
        return PageResult.iPageHandle(list.getTotal(),list.getCurrent(),list.getSize(),list.getRecords());
    }

}




