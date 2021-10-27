package com.yanjing.dao;

import com.yanjing.pojo.Department;
import com.yanjing.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// 员工Dao
@Repository
public class EmployeeDao {
    // 模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;

    // static优先加载，优先于Autowired
    static {
        // 创建一个部门表
        employees = new HashMap<Integer, Employee>();

        // 员工有所属的部门
        employees.put(101, new Employee(1001, "AA", "123456789@qq.com", 0, new Department(101, "后勤部")));
        employees.put(102, new Employee(1002, "BB", "223456789@qq.com", 1, new Department(101, "后勤部")));
        employees.put(103, new Employee(1003, "CC", "323456789@qq.com", 0, new Department(101, "后勤部")));
        employees.put(104, new Employee(1004, "DD", "423456789@qq.com", 1, new Department(101, "后勤部")));
        employees.put(105, new Employee(1005, "EE", "523456789@qq.com", 0, new Department(101, "后勤部")));
    }

    // 主键自增
    private static Integer initId = 1006;

    // 增加一个员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        // 关联外键
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    // 查询全部员工信息
    public Collection<Employee> getAll() {
        return employees.values();
    }

    // 通过id查询员工
    // 正常情况下Mapper对应的数据库
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    // 通过id删除员工
    public void delete(Integer id) {
        employees.remove(id);
    }
}
