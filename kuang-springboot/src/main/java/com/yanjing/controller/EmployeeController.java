package com.yanjing.controller;

import com.yanjing.dao.EmployeeDao;
import com.yanjing.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanjing
 * @date 2021/10/25
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @PostMapping("/emp")
    public void add(Employee employee) {

        employeeDao.save(employee);
    }
}
