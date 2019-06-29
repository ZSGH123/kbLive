package com.kblive.usersystem.web.api.response;

import java.io.Serializable;

public class WebResponse implements Serializable {
    /**
     * 响应状态码
     */
    private int result = 100;

    /**
     * 对result的状态文字描述
     */
    private String message;

    private String apiName;

    /**
     * 实际传送的对象
     */
    private Object data;

    public WebResponse() {

    }

    public WebResponse(String message, String apiName, Object data) {
        this.message = message;
        this.apiName = apiName;
        this.data = data;
    }

    public WebResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }
}
