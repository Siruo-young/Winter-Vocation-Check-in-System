package com.example.winter_vacation_checkin.controller.background;

import com.example.winter_vacation_checkin.reponse.AjaxResult;
import com.example.winter_vacation_checkin.reponse.PageResult;
import com.example.winter_vacation_checkin.service.LaAwardService;
import com.example.winter_vacation_checkin.vo.AwardAddandUpdateVo;
import com.example.winter_vacation_checkin.vo.AwardDetailVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 徐扬
 * @since 2026/2/4 16:27
 */
@RestController
@RequestMapping("/award")
public class AwardController {
    @Resource
    private LaAwardService laAwardService;

    @GetMapping("/list")
    public AjaxResult<PageResult<AwardDetailVo>> getAwardByNameTypeRightsStatusPage(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                                                    @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                                                    @RequestParam(required = false) String name,
                                                                                    @RequestParam(required = false) Integer type,
                                                                                    @RequestParam(required = false) String rightsName,
                                                                                    @RequestParam(required = false) Integer status){
        return AjaxResult.success(laAwardService.getAwardByNameTypeRightsStatusPage(pageNum, pageSize, name, type, rightsName, status));

    }

    @PostMapping("/edit")
    public AjaxResult<Boolean> Awardedit(@RequestBody AwardAddandUpdateVo awardAddandUpdateVo){
        return AjaxResult.success(laAwardService.Awardedit(awardAddandUpdateVo));
    }

    @PostMapping("/add")
    public AjaxResult<Boolean> Awardadd(@RequestBody AwardAddandUpdateVo awardAddandUpdateVo){
        return AjaxResult.success(laAwardService.Awardadd(awardAddandUpdateVo));
    }

    //判断是否有活动与奖品关联
    @GetMapping("/delete")
    public AjaxResult<Boolean> Awarddelete(@RequestParam Long id){
        return AjaxResult.success(laAwardService.Awarddelete(id));
    }
}
