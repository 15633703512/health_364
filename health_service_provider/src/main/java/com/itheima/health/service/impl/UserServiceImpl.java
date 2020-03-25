package com.itheima.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.health.service.UserService;

/**
 * @Author likepei
 * @Date 2020/3/26 2:51
 * @Version v1.0
 * @Description 用户业务接口实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean login(String username, String password) {
        System.out.println("service_provide=======u:" + username + " p:" + password);
        if ("admin".equals(username) && "123".equals(password)){
            return true;
        }
        return false;
    }
}
