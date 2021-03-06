package com.yanjing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yanjing
 * @date 2021/8/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = -6941460099174513754L;

    private int id;

    private String firstname;

    private String lastname;

    private String email;

    private String status;

    private int gender;
}
