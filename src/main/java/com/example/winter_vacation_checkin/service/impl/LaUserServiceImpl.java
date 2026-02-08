package com.example.winter_vacation_checkin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.winter_vacation_checkin.domain.LaUser;
import com.example.winter_vacation_checkin.mapper.LaUserMapper;
import com.example.winter_vacation_checkin.service.LaUserService;
import com.example.winter_vacation_checkin.util.DateSequenceGenerator;
import com.example.winter_vacation_checkin.util.SnowFlakeUtil;
import com.example.winter_vacation_checkin.vo.LaUserAddorUpdateVo;
import com.example.winter_vacation_checkin.vo.LaUserDetailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author 徐扬
* @description 针对表【la_user(用户信息表)】的数据库操作Service实现
* @createDate 2026-02-02 13:29:59
*/
@Service
public class LaUserServiceImpl extends ServiceImpl<LaUserMapper, LaUser>
    implements LaUserService{

    @Override
    public Boolean addUser(LaUserAddorUpdateVo laUserAddorUpdateVo) {
        LaUser laUser = new LaUser();
        BeanUtils.copyProperties(laUserAddorUpdateVo, laUser);
        laUser.setId(SnowFlakeUtil.getDefaultSnowFlakeId());
        laUser.setCreateTime(new Date());
        laUser.setUpdateTime(new Date());
        laUser.setLastLoginTime(new Date());
        laUser.setSn(new DateSequenceGenerator().generateDateBasedCode(laUser.getId()));
        baseMapper.insert(laUser);
        return true;
    }

    @Override
    public LaUserDetailVo detailUser(Long id) {
        LaUserDetailVo laUserDetailVo = new LaUserDetailVo();
        LaUser laUser = baseMapper.selectById(id);
        BeanUtils.copyProperties(laUser, laUserDetailVo);
        return laUserDetailVo;
    }

    @Override
    public List<LaUserDetailVo> listUser() {
        List<LaUserDetailVo> list = baseMapper.listUser();
        return list;
    }

    @Override
    public Boolean updateUser(LaUserAddorUpdateVo laUserAddorUpdateVo) {
        LaUser laUser = new LaUser();
        BeanUtils.copyProperties(laUserAddorUpdateVo, laUser);
        laUser.setUpdateTime(new Date());
        baseMapper.updateById(laUser);
        return true;
    }

    @Override
    public Boolean deleteUser(Long id) {
        baseMapper.deleteUser(id);
        return true;
    }


}




