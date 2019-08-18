package com.kblive.usersystem.services.user;

import org.springframework.stereotype.Component;

import javax.xml.bind.SchemaOutputResolver;

/**
 * title: UserService
 * projectName kbLive
 * description:
 * author 2671242147@qq.com
 * date 2019-08-17 13:39
 ***/
public class UserService implements IUserService {

    public UserService() {
        System.out.println("UserService构造函数初始化");
    }

    @Override
    public void getUser() {
        System.out.println("获取所有用户");
    }
}
