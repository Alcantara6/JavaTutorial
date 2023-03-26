package com.yanjing.reflection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.List;

/**
 * @author yanjing
 * @date 2023/1/5
 */
public class Pojo2 {

    public String getA() {
        return "abc";
    }

    public List<Integer> getB() {
        return Arrays.asList(1, 2, 3);
    }

    public Boolean isC() {
        return true;
    }

    private Integer getD() {
        return 12;
    }

    @JsonIgnore
    private String getE() {
        return "e";
    }
}
