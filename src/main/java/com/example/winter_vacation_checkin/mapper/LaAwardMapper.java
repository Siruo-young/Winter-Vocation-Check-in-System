package com.example.winter_vacation_checkin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.winter_vacation_checkin.domain.LaAward;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.winter_vacation_checkin.vo.AwardDetailVo;
import org.apache.ibatis.annotations.Param;

/**
* @author 徐扬
* @description 针对表【la_award】的数据库操作Mapper
* @createDate 2026-02-04 16:16:45
* @Entity generator.domain.LaAward
*/
public interface LaAwardMapper extends BaseMapper<LaAward> {

    IPage<AwardDetailVo> getAwardByNameTypeRightsStatusPage(Page<AwardDetailVo> page, @Param("name") String name, @Param("type") Integer type, @Param("rightsName") String rightsName, @Param("status") Integer status);

    void updateByActivityId(@Param("id") Long ActivityId);

    LaAward getByActivityId(@Param("activityId") Long activityId);
}




