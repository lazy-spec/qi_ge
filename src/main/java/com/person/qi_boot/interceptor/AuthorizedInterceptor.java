package com.person.qi_boot.interceptor;


import com.person.qi_boot.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizedInterceptor implements HandlerInterceptor {

    /** 定义不需要拦截的请求 */
    private static final String[] IGNORE_URI = {"/loginForm", "/login","/404.html"};
    public static final String USER_SESSION = "user_session";
    public static final String LOGIN = "loginForm";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        /** 默认用户没有登录 */
        boolean flag = false;
        /** 获得请求的ServletPath */
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        /**  判断请求是否需要拦截 */
        for (String s : IGNORE_URI) {
            if (servletPath.contains(s)) {
                flag = true;
                System.out.println("*********************");
                break;
            }
        }
        /** 拦截请求 */
        if (!flag){
            /** 1.获取session中的用户  */
            User user = (User) request.getSession().getAttribute(USER_SESSION);
            /** 2.判断用户是否已经登录 */
            if(user == null){
                /** 如果用户没有登录，跳转到登录页面 */
                request.setAttribute("message", "请先登录再访问网站!");
                request.getRequestDispatcher(LOGIN).forward(request, response);
                return flag;
            }else{
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
