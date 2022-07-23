package com.yanjing.config;

import com.yanjing.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yanjing
 * @date 2021/12/4
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Value("${file.folder}")
    private String fileFolder;

    /**
     * 这里拦截和放行的是rest api，和前端路由守卫不同
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/register", "/login", "/login/v2", "/authentication", "/logout");
    }

    // addResourceHandler、addResourceLocations配置静态资源映射，注意addResourceLocations的路径末尾必须有/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/file/**").addResourceLocations("file:" + fileFolder);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        // 由于跨域情况下会先发出一个 options 请求试探，这个请求是不带 cookie 信息的，所以 shiro 无法获取到 sessionId，将导致认证失败。
        // 在 allowCredentials(true) ，即允许跨域使用 cookie 的情况下，allowedOrigins() 不能使用通配符 *，这也是出于安全上的考虑。
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .allowedOrigins("http://localhost:8080")
                .maxAge(3600);
    }
}
