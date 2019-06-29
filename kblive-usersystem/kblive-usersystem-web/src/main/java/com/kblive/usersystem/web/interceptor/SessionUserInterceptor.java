package com.kblive.usersystem.web.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SessionUserInterceptor extends HandlerInterceptorAdapter {

    /**
     * 不需要验证的loginUser的UR集合
     */
    private List<String> excludeURIs;

    public List<String> getExcludeURIs() {
        return excludeURIs;
    }

    public void setExcludeURIs(List<String> excludeURIs) {
        this.excludeURIs = excludeURIs;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession(true);
        boolean isExcludeUrl = false;
        String url = request.getRequestURI();
        if (excludeURIs != null) {
            for (String uri : excludeURIs) {
                if (url.contains(uri)) {
                    isExcludeUrl = true;
                    break;
                }
            }
        }

        if(url.contains(".js") || url.contains(".css") || url.contains(".woff2")||url.contains(".woff")||url.contains(".ttf")){
            isExcludeUrl = true;
        }
        if (!isExcludeUrl) {
                return false;
        }
        return super.preHandle(request, response, handler);
    }



}
