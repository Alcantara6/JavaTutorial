package com.yanjing.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author yanjing
 * @date 2021/11/3
 */
@Entity
@Data
public class Permission {

    @Id
    @GeneratedValue
    private Long id; // 主键.

    private String name; // 权限名称,如 user:select

    private String description; // 权限描述,用于UI显示

    private String url; // 权限地址.
    @JsonIgnoreProperties(value = {"permissions"})
    @ManyToMany
    @JoinTable(
            name = "role_permission",
            joinColumns = {@JoinColumn(name = "permission_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> roles; // 一个权限可以被多个角色使用

}
