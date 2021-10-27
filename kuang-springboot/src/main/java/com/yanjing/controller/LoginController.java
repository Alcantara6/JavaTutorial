package com.yanjing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author yanjing
 * @date 2021/10/24
 */
@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {

        if ("admin".equals(username) && "123".equals(password) ) {

            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } else {

            model.addAttribute("msg", "用户名或密码错误");
            return "index";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {

        session.invalidate();
        return "redirect:/index.html";
    }
}
