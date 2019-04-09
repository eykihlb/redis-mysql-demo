package com.example.redisdemo.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static String[] IGNORE_URI = {"/login.html", "/login", "/error","/login.html","/error.html"};
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        String url = request.getRequestURL().toString();
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            Object obj = request.getSession().getAttribute("user");
            if (null == obj) {
                String servletPath = request.getServletPath();
                if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
                    response.setHeader("sessionstatus", "timeout");
                    response.setCharacterEncoding("utf-8");
                    response.setContentType("text/html;charset=utf-8");
                    response.getWriter().print("error");
                } else {
                    response.sendRedirect(request.getContextPath()+"/user/loginIndex");
                }
                return false;
            } else {

            }
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }


}
