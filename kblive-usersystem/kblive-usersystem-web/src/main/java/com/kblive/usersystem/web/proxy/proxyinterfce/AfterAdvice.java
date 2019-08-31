package com.kblive.usersystem.web.proxy.proxyinterfce;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * title: AfterAdvice
 * projectName kbLive
 * description: 后置通知
 * author 2671242147@qq.com
 * date 2019-08-31 14:55
 ***/
public class AfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("afterReturning" + "方法名称" + method.getName());
    }
}
