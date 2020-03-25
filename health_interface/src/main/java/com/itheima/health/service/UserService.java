package com.itheima.health.service;

/**
 * @Author likepei
 * @Date 2020/3/26 2:50
 * @Version v1.0
 * @Description 用户业务接口
 */
public interface UserService {

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    boolean login(String username, String password);
}
