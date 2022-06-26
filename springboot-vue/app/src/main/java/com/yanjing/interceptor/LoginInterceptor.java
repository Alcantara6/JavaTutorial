package com.yanjing.interceptor;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yanjing
 * @date 2022/6/18
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 这里拦截和放行的是rest api，和前端路由守卫不同
     */
    // @Override
    // public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    //
    //     UserVo sessionUser = (UserVo) request.getSession().getAttribute("user");
    //
    //     if (sessionUser == null) {
    //
    //         // 前后端不分离方式，跳转到login页面：
    //         // request.getRequestDispatcher("/index.html").forward(request, response);
    //         // 或
    //         // response.sendRedirect("login");
    //         return false;
    //     }
    //     return true;
    // }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 放行 options 请求，否则无法让前端带上自定义的 header 信息，导致 sessionID 改变，shiro 验证失败
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }
        Subject subject = SecurityUtils.getSubject();
        System.out.println("interceptor | isAuthenticated: " + subject.isAuthenticated());
        System.out.println("interceptor | isRemembered: " + subject.isRemembered());
        return subject.isAuthenticated() || subject.isRemembered();
    }
}
