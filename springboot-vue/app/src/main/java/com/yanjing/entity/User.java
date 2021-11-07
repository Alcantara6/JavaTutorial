package com.yanjing.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author yanjing
 * @date 2021/11/7
 * 因为是做前后端分离，而前后端数据交互用的是 json 格式。 那么 User 对象就会被转换为 json 数据。
 * 而本项目使用 jpa 来做实体类的持久化，jpa 默认会使用 hibernate,
 * 在 jpa 工作过程中，就会创造代理类来继承 User ，
 * 并添加 handler 和 hibernateLazyInitializer 这两个无须 json 化的属性，
 * 所以这里需要用 JsonIgnoreProperties 把这两个属性忽略掉。
 */
@Data
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class User implements Serializable {

    private static final long serialVersionUID = 2583167132570687965L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 主键.

    @Column(unique = true)
    private String username; // 登录账户,唯一.

    private String password; // 密码.
}
