package com.example.winter_vacation_checkin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.winter_vacation_checkin.domain.LaUserJoin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.winter_vacation_checkin.vo.UserActivityListVo;
import org.apache.ibatis.annotations.Param;

/**
* @author 徐扬
* @description 针对表【la_user_join】的数据库操作Mapper
* @createDate 2026-02-04 16:16:45
* @Entity generator.domain.LaUserJoin
*/
public interface LaUserJoinMapper extends BaseMapper<LaUserJoin> {

    Long getByActivityId(@Param("activityId") Long id);

    IPage<UserActivityListVo> getUserJoinByNameTypePage(Page<UserActivityListVo> page, @Param("name") String name, @Param("status") Integer status);
}




