package com.yanjing.service;

import com.yanjing.dao.UserDao;
import com.yanjing.vo.user.UserVo;
import com.yanjing.entity.User;
import com.yanjing.exception.BizException;
import com.yanjing.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

/**
 * @author yanjing
 * @date 2021/11/7
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean register(UserVo userVo) {

        String username = userVo.getUsername();
        String password = userVo.getPassword();
        username = HtmlUtils.htmlEscape(username);

        if (isExist(username)) {
            throw new BizException("用戶已存在");
        }
        String salt = EncryptUtil.generateSalt();
        String encryptedPassword = EncryptUtil.encrypt(password, salt);
        User user = new User();
        user.setUsername(username);
        user.setPassword(encryptedPassword);
        user.setSalt(salt);
        add(user);
        return true;
    }

    public boolean login(UserVo userVo) {

        String username = userVo.getUsername();
        username = HtmlUtils.htmlEscape(username);
        User user = getByName(username);
        if (user == null) {
            throw new BizException("用戶不存在");
        }
        String encryptedPassword = EncryptUtil.encrypt(userVo.getPassword(), user.getSalt());
        if (!encryptedPassword.equals(user.getPassword())) {
            throw new BizException("密码错误");
        }
        return true;
    }

    public boolean isExist(String username) {

        User user = getByName(username);
        return user != null;
    }

    public User getByName(String username) {

        return userDao.findByUsername(username);
    }

    public User get(String username, String password) {

        return userDao.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {

        userDao.save(user);
    }
}
