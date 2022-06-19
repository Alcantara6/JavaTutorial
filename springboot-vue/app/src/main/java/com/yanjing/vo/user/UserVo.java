package com.yanjing.vo.user;

import com.yanjing.entity.User;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yanjing
 * @date 2021/11/9
 */
@Data
@Accessors(chain = true)
public class UserVo implements Serializable {

    private static final long serialVersionUID = -2772981566942441101L;

    private String username;

    private String password;

    public static UserVo fromUserDo(User user) {
        UserVo userVo = new UserVo();
        return userVo.setUsername(user.getUsername());
    }
}
