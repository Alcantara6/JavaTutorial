package com.yanjing.entity.admin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "admin_role")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AdminRole implements Serializable {

    private static final long serialVersionUID = -1199519609051971410L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column
    private String name;

    @Column(name = "name_zh")
    private String nameZh;

    @Column(name = "enabled")
    private Integer enabled;

    @ManyToMany
    @JoinTable(name = "admin_role_menu",
            joinColumns = @JoinColumn(name = "rid", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "mid", referencedColumnName = "id"),
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)
    )
    private Set<AdminMenu> adminMenus = new LinkedHashSet<>();
}