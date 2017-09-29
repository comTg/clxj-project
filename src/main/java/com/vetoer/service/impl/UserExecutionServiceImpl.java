package com.vetoer.service.impl;

import com.vetoer.dao.UserDao;
import com.vetoer.dto.UserExecution;
import com.vetoer.entity.User;
import com.vetoer.enums.UserEnum;
import com.vetoer.service.UserExecutionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExecutionServiceImpl implements UserExecutionService {
    // 日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    // 注入service依赖
    @Autowired
    private UserDao userDao;
    
    //  注册用户
    @Override
    public UserExecution registerUser(User user) {
        UserExecution execution = queryByPhone(user.getPhone());
        if(execution.getState()==2){
            return execution;
        }else{
            int result = userDao.addUser(user);
            if(result<=0){
                return new UserExecution(user.getPhone(), UserEnum.FAILED);
            }else{
                User findUser = userDao.queryByPhone(user.getPhone());
                return new UserExecution(findUser.getUserId(),findUser.getPhone(),UserEnum.SUCCESS,findUser);
            }
        }
    }
    // 登录
    @Override
    public UserExecution loginUser(String phone, String password) {
        UserExecution execution = queryByPhone(phone);
        if(execution.getState()==0){
            return execution;
        }else {
            User findUser = userDao.queryUserExists(phone, password);
            if (findUser == null) {
                return new UserExecution(phone, UserEnum.FAILED);
            }
            return new UserExecution(findUser.getUserId(), phone, UserEnum.SUCCESS, findUser);
        }
    }
    // 判断手机号码是否存在
    @Override
    public UserExecution queryByPhone(String phone) {
        User finduser = userDao.queryByPhone(phone);
        if(finduser==null){
            // 返回 state=0,表示手机号码未注册
            return new UserExecution(phone, UserEnum.IS_EXISTS);
        }else{
            // 返回 state=1
            return new UserExecution(phone,UserEnum.HAVE_REGISTER);
        }
    }
    // 找回密码
    @Override
    public UserExecution findPasswd(String phone, String password) {
        UserExecution execution = queryByPhone(phone);
        if(execution.getState()==0){
            return execution;
        }else{
            // 手机号码存在,修改密码
            int result = userDao.alterPasswd(phone,password);
            if(result<=0){
                return new UserExecution(phone,UserEnum.INNER_ERROR);
            }else{
                return new UserExecution(phone,UserEnum.SUCCESS);
            }
        }
    }
}
