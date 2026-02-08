package com.example.winter_vacation_checkin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.winter_vacation_checkin.domain.LaUser;
import com.example.winter_vacation_checkin.vo.LaUserDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 徐扬
* @description 针对表【la_user(用户信息表)】的数据库操作Mapper
* @createDate 2026-02-02 13:29:59
* @Entity generator.domain.LaUser
*/
public interface LaUserMapper extends BaseMapper<LaUser> {

    List<LaUserDetailVo> listUser();

    void deleteUser(@Param("id") Long id);
}




