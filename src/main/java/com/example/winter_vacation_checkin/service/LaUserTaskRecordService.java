package com.example.winter_vacation_checkin.service;

import com.example.winter_vacation_checkin.domain.LaUserTaskRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.winter_vacation_checkin.reponse.PageResult;
import com.example.winter_vacation_checkin.vo.ActivityDetailVo;

/**
* @author 徐扬
* @description 针对表【la_user_task_record】的数据库操作Service
* @createDate 2026-02-04 16:16:44
*/
public interface LaUserTaskRecordService extends IService<LaUserTaskRecord> {

    PageResult<ActivityDetailVo> UserTasklist(Integer pageNum, Integer pageSize);
}
