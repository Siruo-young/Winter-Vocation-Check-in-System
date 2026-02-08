package com.example.winter_vacation_checkin.service;

import com.example.winter_vacation_checkin.domain.LaTask;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.winter_vacation_checkin.reponse.PageResult;
import com.example.winter_vacation_checkin.vo.TaskAddandUpdateVo;
import com.example.winter_vacation_checkin.vo.TaskDetailVo;

/**
* @author 徐扬
* @description 针对表【la_task】的数据库操作Service
* @createDate 2026-02-04 16:16:45
*/
public interface LaTaskService extends IService<LaTask> {

    Boolean add(TaskAddandUpdateVo taskAddandUpdateVo);

    Boolean edit(TaskAddandUpdateVo taskAddandUpdateVo);

    Boolean delete(Long id);

    PageResult<TaskDetailVo> listTask(Integer pageNum, Integer pageSize, String name, Integer type);
}
