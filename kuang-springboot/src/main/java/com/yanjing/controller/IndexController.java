package com.yanjing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

// 需要模板引擎的支持 Thymeleaf
@Controller
public class IndexController {

    @RequestMapping("test")
    public String test(Model model) {
        model.addAttribute("msg", "data for template test");
        return "test";
    }

    /**
     * redirect: 路由到指定
     */
    @RequestMapping({"/test1", "/test2"})
    public String testRedirect(Model model) {
        model.addAttribute("msg", "data for template test1 or test2");
        return "redirect:/main.html";
    }

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg", "成功了...");
        request.setAttribute("code", 200);
        return "forward:/success"; // 转发到/success请求
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute String msg, @RequestAttribute Integer code, HttpServletRequest request) {
        Object msg1 = request.getAttribute("msg");

        Map<String, Object> mapResult = new HashMap<String, Object>();

        mapResult.put("reqMethodMsg", msg1);
        mapResult.put("annotationMsg", msg);
        mapResult.put("annotationCode", code);
        mapResult.put("http-servlet-request", request);

        return mapResult;
    }
}
