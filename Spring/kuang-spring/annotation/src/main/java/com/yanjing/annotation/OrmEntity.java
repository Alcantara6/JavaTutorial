package com.yanjing.annotation;

/**
 * @author yanjing
 * @date 2022/3/20
 */
@OrmTable("db_student")
public class OrmEntity {

    @OrmField(column = "db_id", type = "int", length = 10)
    private Integer id;

    @OrmField(column = "db_age", type = "int", length = 10)
    private Integer age;

    @OrmField(column = "db_name", type = "varchar", length = 3)
    private String name;
}
