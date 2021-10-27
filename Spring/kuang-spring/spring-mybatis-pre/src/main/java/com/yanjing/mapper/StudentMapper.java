package com.yanjing.mapper;

import com.yanjing.pojo.Student;

import java.util.List;

/**
 * @author yanjing
 * @date 2021/8/21
 */
// 接口对应的Mapper映射xml文件：名字相同且在同一个包下
public interface StudentMapper {

    public List<Student> selectStudent();
}
