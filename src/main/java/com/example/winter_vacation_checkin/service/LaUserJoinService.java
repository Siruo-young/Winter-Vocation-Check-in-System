package com.example.winter_vacation_checkin.service;

import com.example.winter_vacation_checkin.domain.LaUserJoin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.winter_vacation_checkin.reponse.PageResult;
import com.example.winter_vacation_checkin.vo.UserActivityListVo;
import com.example.winter_vacation_checkin.vo.UserCheckinDaysVo;
import com.example.winter_vacation_checkin.vo.UserCheckinDetailVo;

/**
* @author 徐扬
* @description 针对表【la_user_join】的数据库操作Service
* @createDate 2026-02-04 16:16:45
*/
public interface LaUserJoinService extends IService<LaUserJoin> {

    PageResult<UserActivityListVo> getUserJoinByNameTypePage(Integer pageNum, Integer pageSize, String name, Integer status);

    Boolean userJoin(Long userId, Long activityId);

    UserCheckinDaysVo getSignDays(Long userId, Long activityId);

    UserCheckinDetailVo sign(Long userId, Long activityId, Long taskId);
}
