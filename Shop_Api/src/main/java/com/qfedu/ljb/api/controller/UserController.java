package com.qfedu.ljb.api.controller;

import com.qfedu.common.vo.R;
import com.qfedu.ljb.api.service.UserService;
import com.qfedu.ljb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@Author feri
 *@Date Created in 2019/6/12 17:19
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/api/user/all.do")
    public R all(){
        return userService.all();
    }
    //新增
    @PostMapping("/api/user/save.do")
    public R save(@RequestBody User user){
        return userService.save(user);
    }
    @GetMapping("api/user/checkphone.do")
    public R check(@RequestParam("phone") String phone){
        return userService.check(phone);
    }
}
