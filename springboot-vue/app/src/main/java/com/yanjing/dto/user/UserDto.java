package com.yanjing.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yanjing
 * @date 2021/11/9
 */
@Data
@AllArgsConstructor
public class UserDto implements Serializable {

    private static final long serialVersionUID = -2772981566942441101L;

    private String username;

    private String password;
}
