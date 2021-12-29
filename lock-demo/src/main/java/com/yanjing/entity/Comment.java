package com.yanjing.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author yanjing
 */
@Data
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long articleId;

    private String content;
}