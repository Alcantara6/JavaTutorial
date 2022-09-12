package com.yanjing.dao.admin;

import com.yanjing.entity.admin.AdminMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminMenuRepository extends JpaRepository<AdminMenu, Integer> {
}