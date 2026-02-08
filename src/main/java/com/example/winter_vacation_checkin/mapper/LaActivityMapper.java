package com.example.winter_vacation_checkin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.winter_vacation_checkin.domain.LaActivity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.winter_vacation_checkin.vo.ActivityDetailVo;
import org.apache.ibatis.annotations.Param;

/**
* @author 徐扬
* @description 针对表【la_activity】的数据库操作Mapper
* @createDate 2026-02-04 16:16:45
* @Entity generator.domain.LaActivity
*/
public interface LaActivityMapper extends BaseMapper<LaActivity> {

    IPage<ActivityDetailVo> getByNameTypePage(Page<ActivityDetailVo> page,@Param("name") String name, @Param("type") Integer type);
}




