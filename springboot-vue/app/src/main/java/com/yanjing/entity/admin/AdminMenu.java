package com.yanjing.entity.admin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author yanjing
 * @date 2022/7/23
 */
@Entity
@Getter
@Setter
@Table(name = "admin_menu")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AdminMenu implements Serializable {

    private static final long serialVersionUID = -198482251158466118L;

    public static final int ROOT_ID = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    Integer id;

    @Column(name = "path")
    String path;

    @Column(name = "name")
    String name;

    @Column(name = "name_zh")
    String nameZh;

    @Column(name = "icon_cls")
    String iconCls;

    @Column(name = "component")
    String component;

    @Column(name = "parent_id")
    Integer parentId;

    @Transient
    List<AdminMenu> children;
}
