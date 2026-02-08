package com.example.winter_vacation_checkin.vo;

import com.example.winter_vacation_checkin.domain.LaAward;
import lombok.Data;

import java.util.List;

/**
 * @author 徐扬
 * @since 2026/2/6 16:11
 */
@Data
public class UserCheckinDetailVo {
    //是否打卡成功：0成功 1失败
    private Boolean isSuccess;

    //是否获奖: 0获奖 1未获奖
    private Boolean isAwarded;

    //奖品列表
    private LaAward award;

}
