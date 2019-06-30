package com.kblive.usersystem.common.db;

import org.apache.log4j.Logger;

/**
 * title: HashFunction
 * projectName kbLive
 * description: 分库路由函数
 * author 2671242147@qq.com
 * date 2019-06-29 15:00
 ***/
public class HashFunction {

    private static final Logger logger = Logger.getLogger(HashFunction.class);

    /**
     * 0标识1库，1标识2库
     *
     * @param fkId
     * @return
     */

    public Integer apply(Integer fkId) {
        if (fkId == null) {
            return 1;
        } else if (fkId == 1) {
            return 1;
        } else if (fkId == 2) {
            return 2;
        } else if (fkId == 3) {
            return 3;
        }
        return 1;
    }

}
