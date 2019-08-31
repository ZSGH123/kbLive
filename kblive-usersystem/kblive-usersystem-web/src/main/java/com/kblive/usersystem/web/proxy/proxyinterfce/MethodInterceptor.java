package com.kblive.usersystem.web.proxy.proxyinterfce;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * title: MethodInterceptor
 * projectName kbLive
 * description: 方法拦截器 （可被用作环绕通知）
 * author 2671242147@qq.com
 * date 2019-08-31 15:04
 ***/
public class MethodInterceptor implements org.aopalliance.intercept.MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("MethodInterceptor1:" + methodInvocation.getMethod().getName());
        Object object = methodInvocation.proceed();
        System.out.println("MethodInterceptor2:" + methodInvocation.getMethod().getName());
        return object;
    }
}
