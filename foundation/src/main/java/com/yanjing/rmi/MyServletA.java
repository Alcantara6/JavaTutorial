package com.yanjing.rmi;

import org.springframework.util.ObjectUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * servlet不是Java标准库的一部分，需要另行下载。这里能引入是因为spring-boot-starter-web包中包含有。
 * @author yanjing
 * @date 2023/6/3
 */
public class MyServletA extends HttpServlet {

    private static final long serialVersionUID = -5217938900887830803L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String message = "If you're reading this, it worked!";

        out.println("<HTML><BODY");
        out.println("<H1>" + message + "</H1");
        out.println("</BODY></HTML>");
        out.close();
    }
}
