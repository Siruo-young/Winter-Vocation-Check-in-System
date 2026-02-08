package com.example.winter_vacation_checkin.controller.background;

import com.example.winter_vacation_checkin.reponse.AjaxResult;
import com.example.winter_vacation_checkin.reponse.PageResult;
import com.example.winter_vacation_checkin.service.LaActivityService;
import com.example.winter_vacation_checkin.service.LaUserJoinService;
import com.example.winter_vacation_checkin.vo.ActivityAddandUpdate;
import com.example.winter_vacation_checkin.vo.ActivityDetailVo;
import com.example.winter_vacation_checkin.vo.UserActivityListVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 徐扬
 * @since 2026/2/4 16:26
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Resource
    private LaActivityService laActivityService;

    @Resource
    private LaUserJoinService laUserJoinService;

    //新增活动接口
    @PostMapping("/add")
    public AjaxResult<Boolean> addActivity(@RequestBody ActivityAddandUpdate activityAddandUpdate){
        return AjaxResult.success(laActivityService.add(activityAddandUpdate));
    }

    //编辑活动接口
    //判断任务有没有修改
    @PostMapping("/edit")
    public AjaxResult<Boolean> editActivity(@RequestBody ActivityAddandUpdate activityAddandUpdate){
        return AjaxResult.success(laActivityService.edit(activityAddandUpdate));
    }

    //删除活动接口
    //校验是否有人报名
    @GetMapping("/delete")
    public AjaxResult<Boolean> deleteActivity(@RequestParam Long id){
        return AjaxResult.success(laActivityService.delete(id));
    }

    //根据活动名称、活动类型查询活动接口
    @GetMapping("/list")
    public AjaxResult<PageResult<ActivityDetailVo>> getActivityByNameTypePage(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                                 @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                                 @RequestParam(required = false) String name,
                                                                 @RequestParam(required = false) Integer type){
        return AjaxResult.success(laActivityService.getByNameTypePage(pageNum, pageSize, name,type));

    }
    //用户报名活动接口
    @GetMapping("/UserActivitylist")
    public AjaxResult<PageResult<UserActivityListVo>> getUserJoinByNameTypePage(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                                                @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                                                @RequestParam(required = false) String name,
                                                                                @RequestParam(required = false) Integer status){
        return AjaxResult.success(laUserJoinService.getUserJoinByNameTypePage(pageNum, pageSize, name, status));

    }
}
