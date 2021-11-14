package com.yanjing.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author yanjing
 * @date 2021/11/14
 */
@Data
@Entity
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Book implements Serializable {

    private static final long serialVersionUID = -6095907068445267102L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name="cid")
    private Category category;

    private String cover;
    private String title;
    private String author;
    private LocalDate date;
    private String press;
    private String abs;
}
