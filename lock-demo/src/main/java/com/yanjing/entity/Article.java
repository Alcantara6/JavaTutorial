package com.yanjing.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author yanjing
 */
@Data
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String title;

    private Long commentCount;
    
    private Long version;
}