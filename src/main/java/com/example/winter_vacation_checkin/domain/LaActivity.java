package com.example.winter_vacation_checkin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 *
 * @TableName la_activity
 */
@TableName(value ="la_activity")
@Data
public class LaActivity {
    /**
     * 活动id
     */
    @TableId
    private Long id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * banner图
     */
    private String bannerMsg;

    /**
     * 封面图
     */
    private String coverMsg;

    /**
     * 介绍图
     */
    private String introduceMsg;

    /**
     * 活动类型：1.打卡
     */
    private Integer type;

    /**
     * 打卡天数
     */
    private Integer days;

    /**
     * 是否限制人数：0限制 1不限制
     */
    private String isLimit;

    /**
     * 活动状态：0进行中 1已结束
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 按钮颜色
     */
    private String buttonColor;

    /**
     * 背景颜色
     */
    private String backgroundColor;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 更新人
     */
    private Long updateUser;

    /**
     * 是否删除：0未删除 1已删除
     */
    private Integer isDelete;

    /**
     * 活动开始时间
     */
    private Date startTime;

    /**
     * 活动结束时间
     */
    private Date endTime;

}