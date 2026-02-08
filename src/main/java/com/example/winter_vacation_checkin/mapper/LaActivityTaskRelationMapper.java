package com.example.winter_vacation_checkin.mapper;

import com.example.winter_vacation_checkin.domain.LaActivityTaskRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 徐扬
* @description 针对表【la_activity_task_relation】的数据库操作Mapper
* @createDate 2026-02-04 16:16:45
* @Entity generator.domain.LaActivityTaskRelation
*/
public interface LaActivityTaskRelationMapper extends BaseMapper<LaActivityTaskRelation> {

    void updateByActivityId(@Param("activityId") Long id);

    Long getLastTask(@Param("userId") Long userId, @Param("activityId") Long activityId);
}




