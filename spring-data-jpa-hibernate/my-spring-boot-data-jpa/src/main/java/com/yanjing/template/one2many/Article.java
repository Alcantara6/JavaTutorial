package com.yanjing.template.one2many;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author yanjing
 * @date 2022/2/20
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Article implements Serializable {

    private static final long serialVersionUID = 2061161309741085753L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "标题不能为空")
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String title;

    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    @Basic(fetch = FetchType.LAZY)
    @NotEmpty(message = "内容不能为空")
    @Size(min = 2)
    @Column(nullable = false)
    @ToString.Exclude
    private String content;

    // 可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    // 设置在article表中的关联字段(外键)
    // 指定外键列，代表该实体类为关系维护方。
    // 在一对多或者一对一的关系下，需要加上@JoinColumn来指定外键列，避免生成一张中间表。
    @JoinColumn(name = "author")
    private Author author;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Article article = (Article) o;
        return id != null && Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
