package com.kblive.usersystem.common.enums;

/**
 * title: EnvEnum
 * projectName kbLive
 * description: 环境枚举
 * author 2671242147@qq.com
 * date 2019-06-29 15:00
 ***/
public enum EnvEnum {
    /**
     * 本地环境
     */
    DEV("dev"),
    /**
     * 测试环境
     */
    TEST("test"),
    /**
     * 正式环境
     */
    PRODUCTION("production");


    private String value;

    EnvEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
