package com.kblive.usersystem.web.filter;


import com.kblive.usersystem.common.constant.SessionConstant;
import com.kblive.usersystem.model.user.KbliveUser;
import com.kblive.usersystem.web.threadlocal.HttpContext;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * title: HttpcontextThreadLocalFilter
 * projectName kbLive
 * description: Http上下文
 * author 2671242147@qq.com
 * date 2019-06-29 15:02
 ***/
public class HttpcontextThreadLocalFilter implements Filter {

    private static final Logger logger = Logger.getLogger(HttpcontextThreadLocalFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
        System.out.println("ThreadLocalFilter已经初始化...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpContext httpContext = HttpContext.getContext();
            httpContext.setRequest((HttpServletRequest) servletRequest);
            httpContext.setResponse((HttpServletResponse) servletResponse);
            try {
                Object kbliveUserObj = httpContext.getRequest().getSession().getAttribute(SessionConstant.KBLIVE_USER);
                if (kbliveUserObj != null) {
                    KbliveUser kbliveUser = (KbliveUser) kbliveUserObj;
                    httpContext.setKbliveUser(kbliveUser);
                }
            } catch (Exception e) {
                logger.error("获取会话异常:" + e.getMessage(), e);
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            HttpContext.removeContext();
        }
    }

    @Override
    public void destroy() {
        System.out.println("ThreadLocalFilter已经被销毁...");
    }
}
