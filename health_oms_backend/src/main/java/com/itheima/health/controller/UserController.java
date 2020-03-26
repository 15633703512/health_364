package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.common.MessageConst;
import com.itheima.health.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("web/user")
public class UserController {

    //依赖注入
    @Reference
    private UserService userService;

    @RequestMapping("/login")
    public Result login(String username, String password){
        System.out.println("oms backend====u:"+username+" ,p:"+password);
        if (userService.login(username, password)){
            System.out.println("login ok!!!");
            return new Result(true, MessageConst.ACTION_SUCCESS);
        } else {
            System.out.println("login fail");
            return new Result(false, MessageConst.ACTION_FAIL);
        }
    }
}
