package com.yanjing.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author yanjing
 * @date 2021/11/3
 */
@Entity
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 6662682406026733565L;

    @Id
    @GeneratedValue
    private Long id; // 主键.

    @Column(unique = true)
    private String username; // 登录账户,唯一.

    private String name; // 名称(匿名或真实姓名),用于UI显示

    private String password; // 密码.

    private String salt; // 加密密码的盐

    @JsonIgnoreProperties(value = {"users"})
    @ManyToMany(fetch = FetchType.EAGER) // 立即从数据库中进行加载数据
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles; // 一个用户具有多个角色
}
