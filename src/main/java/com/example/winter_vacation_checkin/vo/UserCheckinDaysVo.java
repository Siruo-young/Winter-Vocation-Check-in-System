package com.example.winter_vacation_checkin.vo;

import com.example.winter_vacation_checkin.domain.LaTask;
import com.example.winter_vacation_checkin.domain.LaUserTaskRecord;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author 徐扬
 * @since 2026/2/6 14:25
 */
@Data
public class UserCheckinDaysVo {
    //累计打卡天数
    private Integer totalDays;
    //活动开始时间
    private Date startTime;
    //活动结束时间
    private Date endTime;
    //userId + activityId 从现在开始到明天晚上23：59：59


    //连续打卡天数
    private Integer continueNum;

    //打卡列表 根据userId activityId 单表查询la_user_task_record
    private List<LaUserTaskRecord> taskRecordList;

    //今天的任务
    private LaTask task;

    //今日任务 查询所有的 减去已经做的 = 还需要做的任务 去第一个还未做的任务

}
