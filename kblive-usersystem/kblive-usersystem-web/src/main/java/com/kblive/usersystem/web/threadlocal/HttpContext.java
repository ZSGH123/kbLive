package com.kblive.usersystem.web.threadlocal;

import com.kblive.usersystem.model.user.KbliveUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * title: HttpContext
 * projectName kbLive
 * description: Http上下文
 * author 2671242147@qq.com
 * date 2019-06-29 15:02
 ***/
public class HttpContext {

    private static final ThreadLocal<HttpContext> LOCAL = new ThreadLocal<HttpContext>() {
        @Override
        protected HttpContext initialValue() {
            return new HttpContext();
        }
    };

    private HttpServletRequest request;
    private HttpServletResponse response;
    private KbliveUser kbliveUser;

    private HttpContext() {
    }

    public static HttpContext getContext() {
        return LOCAL.get();
    }

    public static void removeContext() {
        LOCAL.remove();
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public KbliveUser getKbliveUser() {
        return kbliveUser;
    }

    public void setKbliveUser(KbliveUser kbliveUser) {
        this.kbliveUser = kbliveUser;
    }
}
