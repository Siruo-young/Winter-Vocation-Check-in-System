package com.example.winter_vacation_checkin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.winter_vacation_checkin.domain.LaUser;
import com.example.winter_vacation_checkin.vo.LaUserAddorUpdateVo;
import com.example.winter_vacation_checkin.vo.LaUserDetailVo;

import java.util.List;

/**
* @author 徐扬
* @description 针对表【la_user(用户信息表)】的数据库操作Service
* @createDate 2026-02-02 13:29:59
*/
public interface LaUserService extends IService<LaUser> {

    Boolean addUser(LaUserAddorUpdateVo laUserAddorUpdateVo);

    LaUserDetailVo detailUser(Long id);

    List<LaUserDetailVo> listUser();

    Boolean updateUser(LaUserAddorUpdateVo laUserAddorUpdateVo);

    Boolean deleteUser(Long id);
}
