package com.example.winter_vacation_checkin.controller.background;

import com.example.winter_vacation_checkin.reponse.AjaxResult;
import com.example.winter_vacation_checkin.service.LaUserService;
import com.example.winter_vacation_checkin.vo.LaUserAddorUpdateVo;
import com.example.winter_vacation_checkin.vo.LaUserDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 徐扬
 * @since 2026/2/2 13:56
 */
@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private LaUserService laUserService;
    /**
     * 添加用户
     * @param laUserAddorUpdateVo
     * @return
     */
    @PostMapping("/addUser")
    public AjaxResult<Boolean> addUser(LaUserAddorUpdateVo laUserAddorUpdateVo){
        return AjaxResult.success(laUserService.addUser(laUserAddorUpdateVo));
    }
    /**
     * 根据id查询用户信息
     * @return
     */
    @GetMapping("/detailUser")
    public AjaxResult<LaUserDetailVo> detailUser(@RequestParam Long id){
        return AjaxResult.success(laUserService.detailUser(id));
    }

    /**
     * 查询用户列表
     * @return
     */
    @GetMapping("/listUser")
    public List<LaUserDetailVo> listUser(){
        List<LaUserDetailVo> laUserDetailVos = laUserService.listUser();
        return laUserDetailVos;
    }
    /**
     * 修改用户信息
     * @param laUserAddorUpdateVo
     * @return
     */
    @PostMapping("/updateUser")
    public AjaxResult<Boolean> updateUser(LaUserAddorUpdateVo laUserAddorUpdateVo){
        return AjaxResult.success(laUserService.updateUser(laUserAddorUpdateVo));
    }
    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("/deleteUser")
    public AjaxResult<Boolean> deleteUser(@RequestParam Long id){
        return AjaxResult.success(laUserService.deleteUser(id));
    }

}
