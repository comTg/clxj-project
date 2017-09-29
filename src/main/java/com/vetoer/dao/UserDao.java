package com.vetoer.dao;

import com.vetoer.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao {
    /**
     * 通过id查询用户
     */
    User queryById(int id);

    /**
     * 根据手机号码查找用户是否存在
     * @param phone
     * @return
     */
    User queryByPhone(String phone);

    /**
     * 通过手机号码和密码查找用户
     */
    User queryUserExists(@Param("phone") String phone,@Param("password") String password);
    /**
     * 查询所有用户
     */
    List<User> queryAll(@Param("offset") int offset,@Param("limit") int limit);

    /**
     * 查询所有用户,没有限制
     * @return
     */
    List<User> queryAllNoLimit();
    /**
     * 添加用户
     */
    int addUser(User user);
    /**
     * 修改用户密码
     */
    int alterPasswd(@Param("phone")String phone,@Param("password")String password);
}
