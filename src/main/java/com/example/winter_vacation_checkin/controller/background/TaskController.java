package com.example.winter_vacation_checkin.controller.background;

import com.example.winter_vacation_checkin.reponse.AjaxResult;
import com.example.winter_vacation_checkin.reponse.PageResult;
import com.example.winter_vacation_checkin.service.LaTaskService;
import com.example.winter_vacation_checkin.service.LaUserTaskRecordService;
import com.example.winter_vacation_checkin.vo.ActivityDetailVo;
import com.example.winter_vacation_checkin.vo.TaskAddandUpdateVo;
import com.example.winter_vacation_checkin.vo.TaskDetailVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 徐扬
 * @since 2026/2/4 16:26
 */
@RestController
@RequestMapping("/activity/task")
public class TaskController {
    @Resource
    private LaTaskService laTaskService;

    @Resource
    private LaUserTaskRecordService laUserTaskRecordService;
    //新增任务接口
    @PostMapping("/add")
    public AjaxResult<Boolean> addTask(@RequestBody TaskAddandUpdateVo taskAddandUpdateVo){
        return AjaxResult.success(laTaskService.add(taskAddandUpdateVo));
    }
    //编辑任务接口
    @PostMapping("/edit")
    public AjaxResult<Boolean> editTask(@RequestBody TaskAddandUpdateVo taskAddandUpdateVo){
        return AjaxResult.success(laTaskService.edit(taskAddandUpdateVo));
    }
    //删除任务接口
    @GetMapping("/delete")
    public AjaxResult<Boolean> deleteTask(@RequestParam Long id){
        return AjaxResult.success(laTaskService.delete(id));
    }

    //根据任务名、任务类型查询任务列表接口
    @GetMapping("/Tasklist")
    public AjaxResult<PageResult<TaskDetailVo>> getTaskByNameTypePage(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                                      @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                                      @RequestParam(required = false) String name,
                                                                      @RequestParam(required = false) Integer type){
        return AjaxResult.success(laTaskService.listTask(pageNum, pageSize, name,type));

    }

    //用户任务记录接口
    @GetMapping("/UserTaskList")
    public AjaxResult<PageResult<ActivityDetailVo>> getUserTaskPage(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                                    @RequestParam(required = false, defaultValue = "10") Integer pageSize){
        return AjaxResult.success(laUserTaskRecordService.UserTasklist(pageNum, pageSize));

    }
}
