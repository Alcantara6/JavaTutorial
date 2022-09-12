package com.yanjing.controller;

import com.yanjing.entity.admin.AdminMenu;
import com.yanjing.service.admin.AdminMenuService;
import com.yanjing.vo.response.Response;
import com.yanjing.vo.response.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yanjing
 * @date 2022/9/12
 */
@RestController
public class MenuController {

    @Autowired
    private AdminMenuService adminMenuService;

    @GetMapping("/user/menu")
    public Response<List<AdminMenu>> menu() {
        List<AdminMenu> menusTree = adminMenuService.getMenusTreeByCurrentUser();
        return ResponseUtils.success(menusTree);
    }
}
