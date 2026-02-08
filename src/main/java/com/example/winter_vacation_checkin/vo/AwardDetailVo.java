package com.example.winter_vacation_checkin.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author 徐扬
 * @since 2026/2/6 10:32
 */
@Data
public class AwardDetailVo {
    //奖品名称
    private String name;

    //图片
    private String photo;

    //类型：1勋章2奖品3会员
    private String type;

    //权益名称
    private String rightsName;

    //已使用
    private Integer useCount;

    //数量限制：0限制1不限制
    private Integer isLimit;

    //状态：1启用2禁用
    private Integer status;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

}
