package com.yanjing.template.one2one;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author yanjing
 * @date 2022/2/19
 */
@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "sex", nullable = false, length = 1)
    private String sex;

    @Column(name = "birthday", nullable = true)
    private Timestamp birthday;

    // Person是关系的维护端，当删除 person，会级联删除 address
    @OneToOne(cascade = {CascadeType.ALL})
    // person中的address_id字段参考address表中的id字段
    // 如果用主键，referencedColumnName可以省略。
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;
}