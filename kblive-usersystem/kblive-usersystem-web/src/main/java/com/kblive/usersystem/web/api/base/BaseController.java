package com.kblive.usersystem.web.api.base;

import com.kblive.usersystem.common.constant.SessionConstant;
import com.kblive.usersystem.common.exception.SessionException;
import com.kblive.usersystem.model.user.KbliveUser;
import com.kblive.usersystem.web.api.response.WebResponse;
import com.kblive.usersystem.web.threadlocal.HttpContext;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {

    public HttpServletRequest getRequest() {
        return HttpContext.getContext().getRequest();
    }

    public HttpServletResponse getResponse() {
        return HttpContext.getContext().getResponse();
    }


    protected HttpSession getSession() throws SessionException {
        HttpSession httpSession = getRequest().getSession(true);
        if (null == httpSession) {
            throw new SessionException("用户会话失效！");
        }
        return httpSession;
    }


    public KbliveUser getKbliveUser() throws SessionException {
        HttpContext context = HttpContext.getContext();
        KbliveUser kbliveUser = null;
        if (context != null && context.getKbliveUser() != null) {
            kbliveUser = context.getKbliveUser();
            if (kbliveUser == null) {
                throw new SessionException("用户会话失效，请重新登录！");
            }
        }
        return kbliveUser;
    }


    protected void setKbliveUser(HttpSession session, KbliveUser kbliveUser) {
        session.setAttribute(SessionConstant.KBLIVE_USER , kbliveUser);
    }


    /**
     * 构建响应结果
     */
    public WebResponse buildResponse(Object data) {
        WebResponse webResponse = new WebResponse();
        webResponse.setData(data);
        webResponse.setResult(100);
        return webResponse;
    }

    /**
     * 构建响应结果
     */
    public WebResponse buildResponse(Object data, Integer result) {
        WebResponse webResponse = new WebResponse();
        webResponse.setData(data);
        webResponse.setResult(result);
        return webResponse;
    }

    /**
     * 返回错误消息
     */
    public WebResponse buildResponse(String message, Integer result) {
        WebResponse webResponse = new WebResponse();
        webResponse.setMessage(message);
        webResponse.setResult(result);
        return webResponse;
    }

    /**
     * 构建成功响应结果
     */
    public WebResponse buildSuccessResponse() {
        WebResponse webResponse = new WebResponse();
        webResponse.setData("success!");
        webResponse.setResult(100);
        return webResponse;
    }

    /**
     * 获取项目的路径
     */
    protected String getRealPath() {
        return HttpContext.getContext().getRequest().getSession().getServletContext().getRealPath("/doctemplate");
    }
}
