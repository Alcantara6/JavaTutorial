package com.yanjing.reflection;

import lombok.*;

/**
 * @author yanjing
 * @date 2022/9/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pojo {

    private Integer id;

    private int primitiveInt;

    private String name;

    // 注意primitive boolean生成的getter是is开头
    private boolean active;
}
