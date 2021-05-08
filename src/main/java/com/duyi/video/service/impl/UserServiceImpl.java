package com.duyi.video.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.duyi.video.dao.UserDao;
import com.duyi.video.entity.User;
import com.duyi.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sujuntao
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User checkEmail(String email) {

        HashMap<String, Object> map = new HashMap<>(1);
        map.put("email", email);

        List<User> userList = userDao.findUserByCondition(map);

        if (userList != null & userList.size() >= 1) {

            return userList.get(0);
        }

        return null;
    }

    @Override
    public User regist(User user) {

        user.setPassword(DigestUtil.md5Hex(user.getPassword()));
        user.setCreateTime(new Date());
        user.setVipFlag(0);
        int code = userDao.insertUser(user);

        if (code != 1) {

            return null;
        }

        return user;
    }

    @Override
    public User login(String email, String password) {

        HashMap<String, Object> map = new HashMap<>(2);
        map.put("email", email);
        map.put("password", DigestUtil.md5Hex(password));

        List<User> userList = userDao.findUserByCondition(map);

        if (userList == null || userList.size() == 0) {

            return null;
        }

        return userList.get(0);
    }

    @Override
    public boolean resetPwd(String email, String password) {

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("email", email);

        List<User> list = userDao.findUserByCondition(map);

        if (list == null || list.size() == 0) {

            return false;
        }

        User user = list.get(0);

        HashMap<String, Object> hashMap = new HashMap<>();
        // user.setPassword(); X
        hashMap.put("id", user.getId());
        hashMap.put("password", DigestUtil.md5Hex(password));

        int code = userDao.updateUser(hashMap);

        return code == 1 ? true : false;
    }
}
