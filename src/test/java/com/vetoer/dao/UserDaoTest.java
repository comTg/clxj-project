package com.vetoer.dao;

import com.vetoer.BaseTest;
import com.vetoer.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoTest extends BaseTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testAddUser() throws Exception{
        User user = new User("tg","xxxx","10102101");
        int result = userDao.addUser(user);
        System.out.println("test---over");
        System.out.println(user);
    }
    @Test
    public void testQueryById() throws Exception{
        int userId = 4;
        User user = userDao.queryById(userId);
        System.out.println(user);
    }
    @Test
    public void testQueryAll() throws Exception{
        List<User> user_lists = userDao.queryAll(0,5);
        for(User user:user_lists){
            System.out.println(user);
        }
    }
    @Test
    public void testQueryByPhone() throws Exception{
        User user = userDao.queryByPhone("101021011");
        if(user==null) {
            System.out.println("null");
        }else{
            System.out.println(user);
        }
    }
    @Test
    public void testQueryNoLimit(){
        List<User> all_user = userDao.queryAllNoLimit();
        for(User user:all_user){
            System.out.println(user);
        }
    }
}
