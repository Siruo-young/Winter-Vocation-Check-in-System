package com.example.winter_vacation_checkin.service;

import com.example.winter_vacation_checkin.domain.LaActivity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.winter_vacation_checkin.reponse.PageResult;
import com.example.winter_vacation_checkin.vo.ActivityAddandUpdate;
import com.example.winter_vacation_checkin.vo.ActivityDetailVo;

/**
* @author 徐扬
* @description 针对表【la_activity】的数据库操作Service
* @createDate 2026-02-04 16:16:45
*/
public interface LaActivityService extends IService<LaActivity> {

    Boolean add(ActivityAddandUpdate activityAddandUpdate);

    Boolean edit(ActivityAddandUpdate activityAddandUpdate);

    Boolean delete(Long id);

    PageResult<ActivityDetailVo> getByNameTypePage(Integer pageNum, Integer pageSize, String name, Integer type);
}
