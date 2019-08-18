package com.kblive.usersystem.web.aspect;

import com.kblive.usersystem.common.utils.datetools.DateTools;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Date;

/**
 * title: Biz
 * projectName kbLive
 * description: 切面
 * author 2671242147@qq.com
 * date 2019-08-18 17:18
 ***/
public class Biz {

    public Biz() {
        System.out.println("Biz");
    }

    public void before() {
        System.out.println("调用 BizAspect before:" + DateTools.dateToStrWithTime(new Date()));
    }

    public void afterReturning() {
        System.out.println("调用 BizAspect afterReturning:" + DateTools.dateToStrWithTime(new Date()));
    }

    public void afterThrowing() {
        System.out.println("调用 BizAspect afterThrowing:" + DateTools.dateToStrWithTime(new Date()));
    }

    public void after() {
        System.out.println("调用 BizAspect after:" + DateTools.dateToStrWithTime(new Date()));
    }

    public Object around(ProceedingJoinPoint pgp) throws Throwable {
        System.out.println("调用 BizAspect around before:" + DateTools.dateToStrWithTime(new Date()));
        Object res = pgp.proceed();
        System.out.println("调用 BizAspect around after:" + DateTools.dateToStrWithTime(new Date()));
        return res;
    }
}
