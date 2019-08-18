package com.kblive.usersystem.services.user;

import org.springframework.stereotype.Component;

/**
 * title: SpecialUserService
 * projectName kbLive
 * description: 特殊永湖服务层
 * author 2671242147@qq.com
 * date 2019-08-17 13:41
 ***/

public class SpecialUserService implements IUserService {
    @Override
    public void getUser() {
        System.out.println("获取所有用户");
    }
}
