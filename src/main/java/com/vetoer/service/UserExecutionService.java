package com.vetoer.service;

import com.vetoer.dto.UserExecution;
import com.vetoer.entity.User;

/**
 * 注册接口: 站在使用者的角度设计接口
 * 1. 
 */
public interface UserExecutionService {
    // 注册用户到数据库
    UserExecution registerUser(User user);
    // 根据用户手机号码和密码登录
    UserExecution loginUser(String phone,String password);
    // 根据手机找回密码
    UserExecution queryByPhone(String phone);
}
