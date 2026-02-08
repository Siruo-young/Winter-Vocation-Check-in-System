package com.example.winter_vacation_checkin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.winter_vacation_checkin.domain.LaAward;
import com.example.winter_vacation_checkin.reponse.PageResult;
import com.example.winter_vacation_checkin.service.LaAwardService;
import com.example.winter_vacation_checkin.mapper.LaAwardMapper;
import com.example.winter_vacation_checkin.util.SnowFlakeUtil;
import com.example.winter_vacation_checkin.vo.ActivityDetailVo;
import com.example.winter_vacation_checkin.vo.AwardAddandUpdateVo;
import com.example.winter_vacation_checkin.vo.AwardDetailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author 徐扬
* @description 针对表【la_award】的数据库操作Service实现
* @createDate 2026-02-04 16:16:45
*/
@Service
public class LaAwardServiceImpl extends ServiceImpl<LaAwardMapper, LaAward>
    implements LaAwardService{
    @Resource
    private LaAwardMapper laAwardMapper;

    @Override
    public PageResult<AwardDetailVo> getAwardByNameTypeRightsStatusPage(Integer pageNum, Integer pageSize, String name, Integer type, String rightsName, Integer status) {
        Page<AwardDetailVo> page = new Page<>(pageNum,pageSize);
        if (StringUtils.isEmpty(name)){
            name = null;
        }
        IPage<AwardDetailVo> list = baseMapper.getAwardByNameTypeRightsStatusPage(page, name, type, rightsName, status);
        return PageResult.iPageHandle(list.getTotal(),list.getCurrent(),list.getSize(),list.getRecords());

    }

    @Override
    public Boolean Awardedit(AwardAddandUpdateVo awardAddandUpdateVo) {
        LaAward laAward = new LaAward();
        BeanUtils.copyProperties(awardAddandUpdateVo,laAward);
        laAward.setUpdateTime(new Date());
        int update = baseMapper.updateById(laAward);
        return update > 0;
    }

    @Override
    public Boolean Awardadd(AwardAddandUpdateVo awardAddandUpdateVo) {
        LaAward laAward = new LaAward();
        BeanUtils.copyProperties(awardAddandUpdateVo,laAward);
        laAward.setCreateTime(new Date());
        laAward.setUpdateTime(new Date());
        laAward.setId(SnowFlakeUtil.getDefaultSnowFlakeId());
        laAward.setIsDelete(0);
        int insert = baseMapper.insert(laAward);
        return insert > 0;
    }

    @Override
    public Boolean Awarddelete(Long id) {
        //奖品与活动有关联
        if(laAwardMapper.selectById(id).getActivityId() != null){
            return false;
        }
        laAwardMapper.selectById(id).setIsDelete(1);
        return true;
    }
}




