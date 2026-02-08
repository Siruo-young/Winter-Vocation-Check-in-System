package com.example.winter_vacation_checkin.vo;

import lombok.Data;

/**
 * @author 徐扬
 * @since 2026/2/5 20:32
 */
public class UserActivityListVo {
    //活动名称
    private String activityName;
    //活动状态
    private Integer activityStatus;
    //用户名称
    private String userName;
    //活动开始时间
    private Data startTime;
    //活动结束时间
    private Data endTime;
}
