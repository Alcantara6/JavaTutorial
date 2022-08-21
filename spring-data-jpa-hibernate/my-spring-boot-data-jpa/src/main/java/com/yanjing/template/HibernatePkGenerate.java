package com.yanjing.template;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author yanjing
 * @date 2022/2/15
 * Hibernate中的主键生成策略
 * https://blog.csdn.net/qq_36662478/article/details/89111437
 */
@Entity
@Data
public class HibernatePkGenerate implements Serializable {

    /**
     * increment, identity, sequence, native, uuid, assigned
     */
    @Id
    // generator属性用于引用@GenericGenerator注解name属性的值
    @GeneratedValue(generator = "by-uuid")
    // GenericGenerator注解是hibernate提供的。
    // strategy属性用于指定hibernate中提供的生成规则
    // name属性用于给使用的生成规则起个名称，以供JPA引用
    @GenericGenerator(name = "by-uuid", strategy = "uuid")
    private Long id;
}
