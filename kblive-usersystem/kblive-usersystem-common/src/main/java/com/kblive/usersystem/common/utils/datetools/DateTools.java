package com.kblive.usersystem.common.utils.datetools;

import org.apache.commons.lang3.StringUtils;

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

    /**
     * 返回日期对应格式的字符串
     *
     * @param d       日期
     * @param pattern 格式原型
     * @return 对应pattern格式的字符串
     */
    public static String dateToStr(Date d, String pattern) {
        if (d == null || StringUtils.isBlank(pattern)) {
            return "1970-01-01 00:00:00";
        }
        return new SimpleDateFormat(pattern).format(d);
    }

    public static String dateToStrWithTime(Date d) {
        return dateToStr(d, "yyyy-MM-dd HH:mm:ss");
    }

    public static String dateToStrWithTimeStart(Date d) {
        return dateToStr(d, "yyyy-MM-dd 00:00:00");
    }

    public static String dateToStrWithTimeEnd(Date d) {
        return dateToStr(d, "yyyy-MM-dd 23:59:59");
    }

    public static String dateToStrNoWithTime(Date d) {
        return dateToStr(d, "yyyy-MM-dd");
    }

    public static String dateToStrNoWithTimeNoLine(Date d) {
        return dateToStr(d, "yyyyMMdd");
    }

    public static String dateToStrOnlyWithTime(Date d) {
        return dateToStr(d, "HH:mm:ss");
    }

    /**
     * 将日期字符串转化为指定格式的日期类型
     *
     * @param str     日期字符串
     * @param pattern 格式
     * @return Date
     */
    public static Date strToDate(String str, String pattern) {
        if (StringUtils.isBlank(str) || StringUtils.isBlank(pattern)) {
            return null;
        }
        try {
            return new SimpleDateFormat(pattern).parse(str);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date strToDateWithTime(String str) {
        return strToDate(str,"yyyy-MM-dd HH:mm:ss");
    }

    public static Date strToDateNoWithTime(String str) {
        return strToDate(str,"yyyy-MM-dd");
    }

    /**
     * 获取某个日期的一天的开始日期
     * @param date 日期
     * @return 返回该日期的yyyy-MM-dd 00:00:00
     */
    public static Date getOneDayStart(Date date) {
        return strToDateWithTime(dateToStrWithTimeStart(date));
    }

    /**
     * 获取某个日期的一天的结束日期
     * @param date 日期
     * @return 返回该日期的yyyy-MM-dd 23:59:59
     */
    public static Date getOneDayEnd(Date date) {
        return strToDateWithTime(dateToStrWithTimeEnd(date));
    }

    public static void main(String[] args) {
        System.out.println(getOneDayEnd(new Date()));
        System.out.println(getOneDayStart(new Date()));
    }

}
