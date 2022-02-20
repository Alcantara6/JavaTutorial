package com.yanjing.template.many2many;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yanjing
 * @date 2022/2/20
 */
@Entity
@Data
public class Authority implements Serializable {

    private static final long serialVersionUID = -1133682399252559406L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name; //权限名

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users = new HashSet<>();
}