package com.duyi.video.service;

import com.duyi.video.entity.User;


/**
 * @author sujuntao
 */
public interface UserService {

    /**
     *  验证邮箱
     * @param email
     * @return
     */
     User checkEmail(String email);

    /**
     *  用户注册
     * @param user
     * @return
     */
    User regist(User user);

    /**
     *  用户登录
     * @param email
     * @param password
     * @return
     */
    User login(String email, String password);

    /**
     *  （修改密码）重置密码
     * @param email
     * @param password
     * @return
     */
    boolean resetPwd(String email, String password);
}
