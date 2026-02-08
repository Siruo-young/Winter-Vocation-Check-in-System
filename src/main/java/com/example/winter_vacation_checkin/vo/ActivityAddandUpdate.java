package com.example.winter_vacation_checkin.vo;

import com.example.winter_vacation_checkin.domain.LaActivity;
import lombok.Data;

import java.util.List;

/**
 * @author 徐扬
 * @since 2026/2/5 11:26
 */
@Data
public class ActivityAddandUpdate extends LaActivity {
    //任务id列表
    private List<Long> taskIdList;
}
