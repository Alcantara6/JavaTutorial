package com.yanjing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanjing
 * @date 2021/10/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    private int id;
    
    private String name;
    
    private String pwd;
}
