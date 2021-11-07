package com.yanjing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yanjing
 * @date 2021/11/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {

    private static final long serialVersionUID = -3382241723435022767L;

    private int code;
}
