package com.yanjing.template;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author yanjing
 * @date 2022/2/15
 * JPA中的主键生成策略
 * https://blog.csdn.net/qq_36662478/article/details/89111437
 */
@Entity
@Data
public class JpaPkGenerate implements Serializable {

    /**
     * IDENTITY:主键由数据库自动生成（主要是自动增长型）,底层数据库必须支持自动增长，比如MySQL
     * SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列，底层数据库必须支持序列，比如Oracle
     * TABLE：jpa提供的一种机制，使用一个特定的数据库表格来保存主键
     * AUTO：将主键生成的策略交给持久化引擎 (persistence engine) 来选择一个。auto策略是JPA默认的策略。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
