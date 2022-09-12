package com.yanjing.service.admin;

import com.yanjing.dao.UserDao;
import com.yanjing.entity.User;
import com.yanjing.entity.admin.AdminMenu;
import com.yanjing.entity.admin.AdminRole;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author yanjing
 * @date 2022/9/12
 */
@Service
public class AdminMenuService {

    /**
     * 注意不能用构造器注入，与Shiro不兼容
     */
    @Autowired
    private UserDao userDao;

    public List<AdminMenu> getMenusTreeByCurrentUser() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userDao.findWithMenusByUsername(username);
        List<AdminMenu> menus = user.getAdminRoles().stream().map(AdminRole::getAdminMenus).flatMap(Collection::stream).collect(Collectors.toList());
        return buildMenusTree(menus);
    }

    private List<AdminMenu> buildMenusTree(List<AdminMenu> menus) {
        for (AdminMenu menu : menus) {
            List<AdminMenu> children = menus.stream().filter(m -> Objects.equals(menu.getId(), m.getParentId())).collect(Collectors.toList());
            menu.setChildren(children);
        }
        menus.removeIf(menu -> menu.getParentId() != AdminMenu.ROOT_ID);
        return menus;
    }
}
