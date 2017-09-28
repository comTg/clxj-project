package com.vetoer.dto;

import com.vetoer.entity.User;
import com.vetoer.enums.UserEnum;

/**
 * 封装注册和登录执行后结果
 */
public class UserExecution {
    private int id;
    // 用户手机号码
    private String phone;
    // 执行之后的状态
    private int state;
    // 执行之后的结果
    private String stateInfo;
    // 用户操作成功后需要返回的用户对象
    private User user;
    //执行成功
    public UserExecution(int id, String phone, UserEnum statEnum, User user){
        this.id = id;
        this.phone = phone;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.user = user;
    }

    // 执行失败
    public UserExecution(String phone, UserEnum statEnum){
        this.phone = phone;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateinfo) {
        this.stateInfo = stateinfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserExecution{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", state=" + state +
                ", stateinfo='" + stateInfo + '\'' +
                '}';
    }
}
