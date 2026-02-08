package com.example.winter_vacation_checkin.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author 徐扬
 * @since 2026/2/5 16:35
 */
@Data
public class ActivityDetailVo {
    //活动名称
    private String activityName;
    //活动类型 1打卡
    private Integer activityType;
    //活动开始时间
    private Date activityStartTime;
    //活动结束时间
    private Date activityEndTime;
    //人数限制
    private String activityLimit;
    //已报名人数
    private Long userCounts;
    //状态 0进行中 1已结束
    private Integer activityStatus;
    //创建时间
    private Date activityCreateTime;
    //更新时间
    private Date activityUpdateTime;
}
