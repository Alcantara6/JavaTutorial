package com.yanjing.template.one2one;

import lombok.Data;

import javax.persistence.*;

/**
 * @author yanjing
 * @date 2022/2/19
 */
@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "zipcode", nullable = false, length = 6)
    private String zipcode;

    // 单向与双向关联
    // 如果不需要根据Address级联查询People，可以注释掉
    @OneToOne(
            mappedBy = "address",
            cascade = {CascadeType.MERGE, CascadeType.REFRESH},
            optional = false
    )
    private Person person;
}