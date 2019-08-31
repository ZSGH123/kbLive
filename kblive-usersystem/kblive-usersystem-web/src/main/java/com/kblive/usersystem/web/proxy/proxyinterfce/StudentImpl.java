package com.kblive.usersystem.web.proxy.proxyinterfce;

/**
 * title: StudentImpl
 * projectName kbLive
 * description:
 * author 2671242147@qq.com
 * date 2019-08-31 14:42
 ***/
public class StudentImpl implements IStudent {
    @Override
    public void save() {
        System.out.println("保存学生成功");
    }

    public void saveTest() {
        System.out.println("保存学生成功11111");
    }
}
