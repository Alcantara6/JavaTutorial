package com.yanjing.error;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author yanjing
 * @date 2021/11/8
 * 前端history模式(打包文件放在resources)，跳转自定义404页面
 */
@Component
public class ErrorConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {

        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");
        registry.addErrorPages(error404Page);
    }
}
