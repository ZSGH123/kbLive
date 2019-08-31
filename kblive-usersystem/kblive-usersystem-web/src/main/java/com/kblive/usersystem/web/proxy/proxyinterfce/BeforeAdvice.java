package com.kblive.usersystem.web.proxy.proxyinterfce;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * title: BeforeAdvice
 * projectName kbLive
 * description: 前置通知bean ,必须实现MethodBeforeAdvice
 * author 2671242147@qq.com
 * date 2019-08-31 14:51
 ***/
public class BeforeAdvice implements MethodBeforeAdvice {


    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("保存学生的前置通知" + "方法名字：" + method.getName());
    }
}
