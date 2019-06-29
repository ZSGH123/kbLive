package com.kblive.usersystem.common.utils.datetools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * title: DateTools
 * projectName kbLive
 * description: 日期工具
 * author 2671242147@qq.com
 * date 2019-06-29 14:59
 ***/
public class DateTools {

    public static String dateToStrWithTime(Date d){
        if(d==null) return  "";
        String s=null;
        String pattern="yyyy-MM-dd HH:mm:ss";
        s=new SimpleDateFormat(pattern).format(d);
        return  s;
    };

    public static Date  strToDate(String str) {
        Date d=null;
        String pattern="yyyy-MM-dd";
        SimpleDateFormat format=new SimpleDateFormat(pattern);
        if(str==null){
            return new Date();
        }
        try {
            return format.parse(str);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String dateToStr(Date d,String pattern) {
        String s = null;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        s = formatter.format(d);
        return s;
    }

}
