package com.example.winter_vacation_checkin.service;

import com.example.winter_vacation_checkin.domain.LaAward;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.winter_vacation_checkin.reponse.PageResult;
import com.example.winter_vacation_checkin.vo.AwardAddandUpdateVo;
import com.example.winter_vacation_checkin.vo.AwardDetailVo;

/**
* @author 徐扬
* @description 针对表【la_award】的数据库操作Service
* @createDate 2026-02-04 16:16:45
*/
public interface LaAwardService extends IService<LaAward> {

    PageResult<AwardDetailVo> getAwardByNameTypeRightsStatusPage(Integer pageNum, Integer pageSize, String name, Integer type, String rightsName, Integer status);

    Boolean Awardedit(AwardAddandUpdateVo awardAddandUpdateVo);

    Boolean Awardadd(AwardAddandUpdateVo awardAddandUpdateVo);

    Boolean Awarddelete(Long id);
}
