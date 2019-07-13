package com.kblive.usersystem.common.exception;

/**
 * title: SessionException
 * projectName kbLive
 * description: 会话异常
 * author 2671242147@qq.com
 * date 2019-07-13 23:58
 ***/
public class SessionException extends Exception {

    private static final long serialVersionUID = 1L;

    public SessionException() {
        super();
    }

    public SessionException(String message) {
        super(message);
    }

    public SessionException(String message, Throwable cause) {
        super(message, cause);
    }

    public SessionException(Exception e) {
        super(e);
    }

}
