package com.kblive.usersystem.common.enums;

/**
 * title: DateTools
 * projectName kbLive
 * description: 记录状态枚举
 * author 2671242147@qq.com
 * date 2019-06-29 14:59
 ***/
public enum EnableStatusEnum {
    /**
     * 失效
     */
    DISABLE(0),
    /**
     * 可用
     */
    ENABLE(1);

    private Integer value;

    EnableStatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
