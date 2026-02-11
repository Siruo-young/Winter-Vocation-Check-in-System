package com.example.winter_vacation_checkin.controller.miniwechat;

import com.example.winter_vacation_checkin.reponse.AjaxResult;
import com.example.winter_vacation_checkin.reponse.PageResult;
import com.example.winter_vacation_checkin.service.LaActivityService;
import com.example.winter_vacation_checkin.service.LaUserJoinService;
import com.example.winter_vacation_checkin.vo.UserActivityListVo;
import com.example.winter_vacation_checkin.vo.UserCheckinDaysVo;
import com.example.winter_vacation_checkin.vo.UserCheckinDetailVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 徐扬
 * @since 2026/2/6 12:25
 */
@RestController
@RequestMapping("/miniwechat/activity")
public class MiniActivityController {
    @Resource
    private LaActivityService laActivityService;

    @Resource
    private LaUserJoinService laUserJoinService;

    //查询活动列表
    @GetMapping("/list")
    public AjaxResult<PageResult<UserActivityListVo>> getUserJoinByNameTypePage(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                                                @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                                                @RequestParam(required = false) String name,
                                                                                @RequestParam(required = false) Integer status){
        return AjaxResult.success(laUserJoinService.getUserJoinByNameTypePage(pageNum, pageSize, name, status));

    }

    //报名
    @PostMapping("/join")
    public AjaxResult<Boolean> userJoin(@RequestParam Long userId, @RequestParam Long activityId){
        return AjaxResult.success(laUserJoinService.userJoin(userId, activityId));
    }

    //查询打卡日历
    @GetMapping("/getSignDays")
    public AjaxResult<UserCheckinDaysVo> getSignDays(@RequestParam Long userId, @RequestParam Long activityId){
        return AjaxResult.success(laUserJoinService.getSignDays(userId,activityId));
    }

    //打卡
    @PostMapping("/sign")
    public AjaxResult<UserCheckinDetailVo> sign(@RequestParam Long userId,
                                                @RequestParam Long activityId,
                                                @RequestParam Long task_id){
        return AjaxResult.success(laUserJoinService.sign(userId, activityId,task_id));
    }
}
