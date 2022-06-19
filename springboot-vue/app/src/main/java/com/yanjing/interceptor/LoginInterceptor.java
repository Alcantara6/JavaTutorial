package com.yanjing.interceptor;

import com.yanjing.dto.user.UserVo;
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
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        UserVo sessionUser = (UserVo) request.getSession().getAttribute("user");

        if (sessionUser == null) {

            // 前后端不分离方式，跳转到login页面：
            // request.getRequestDispatcher("/index.html").forward(request, response);
            // 或
            // response.sendRedirect("login");
            return false;
        }
        return true;
    }
}
