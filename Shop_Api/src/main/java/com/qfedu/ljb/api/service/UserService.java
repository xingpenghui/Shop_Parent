package com.qfedu.ljb.api.service;

import com.qfedu.common.exception.UserException;
import com.qfedu.common.vo.R;
import com.qfedu.ljb.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *@Author feri
 *@Date Created in 2019/6/12 17:18
 */
@FeignClient(name = "UserProvider")
public interface UserService {
    @GetMapping("user/all.do")
    R all();
    //新增
    @PostMapping("user/save.do")
    R save(@RequestBody User user);
}
