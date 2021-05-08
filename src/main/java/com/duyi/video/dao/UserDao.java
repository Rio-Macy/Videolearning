package com.duyi.video.dao;

import com.duyi.video.entity.User;
import java.util.List;
import java.util.Map;

/**
 *  此包已被扫描 要么获取一些值，要么标识一些类放到spring容器内
 * @author sujuntao
 */
public interface UserDao {

    /**
     *  添加一个用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     *  用户条件查询
     *  @param map 包含用户的查询的条件
     *
     * @return
     */
    List<User> findUserByCondition(Map<String, Object> map);

    /**
     *  修改用户信息
     * @param map
     * @return
     */
    int updateUser(Map<String, Object> map);


}
