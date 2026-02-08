package com.example.winter_vacation_checkin.vo;

import lombok.Data;

/**
 * @author 徐扬
 * @since 2026/2/5 20:03
 */
@Data
public class UserTaskListVo {
    //活动名称
    private String activityName;
    //任务名称
    private String taskName;
    //用户名称
    private String userName;
    //用户-任务创建时间
    private Data createTime;
    //用户-任务更新时间
    private Data updateTime;
}
