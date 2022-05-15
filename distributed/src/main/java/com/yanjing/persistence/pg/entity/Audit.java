package com.yanjing.persistence.pg.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author yanjing
 * @date 2022/5/15
 */
@Entity
@Data
@Table(name = "audit")
public class Audit implements Serializable {

    private static final long serialVersionUID = 8981716914053027299L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
}
