package com.example.winter_vacation_checkin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.winter_vacation_checkin.domain.LaUserTaskRecord;
import com.example.winter_vacation_checkin.reponse.PageResult;
import com.example.winter_vacation_checkin.service.LaUserTaskRecordService;
import com.example.winter_vacation_checkin.mapper.LaUserTaskRecordMapper;
import com.example.winter_vacation_checkin.vo.ActivityDetailVo;
import com.example.winter_vacation_checkin.vo.UserTaskListVo;
import org.springframework.stereotype.Service;

/**
* @author 徐扬
* @description 针对表【la_user_task_record】的数据库操作Service实现
* @createDate 2026-02-04 16:16:44
*/
@Service
public class LaUserTaskRecordServiceImpl extends ServiceImpl<LaUserTaskRecordMapper, LaUserTaskRecord>
    implements LaUserTaskRecordService{

    @Override
    public PageResult<ActivityDetailVo> UserTasklist(Integer pageNum, Integer pageSize) {
        Page<UserTaskListVo> page = new Page<>(pageNum,pageSize);
        IPage<ActivityDetailVo> list = baseMapper.UserTasklist(page);
        return PageResult.iPageHandle(list.getTotal(),list.getCurrent(),list.getSize(),list.getRecords());
    }

}




