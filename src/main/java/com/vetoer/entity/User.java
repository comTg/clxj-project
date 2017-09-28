package com.vetoer.entity;

import java.util.Date;

/**
 * 用户类
 */

public class User {
    private int userId;
    private String name;
    private String password;
    private String phone;
    private String email;
    private String realname;
    private String gender;
    private String idcard;
    private Date registerTime;
    private int state;

    public User() {
    }

    public User(String name, String password, String phone) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.registerTime = new Date();
        this.state = 1;
    }

    public User(String name, String password, String phone, String email) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.registerTime = new Date();
    }

    public User(int userId, String name, String password, String phone, String email, String realname, String gender, String idcard, Date registerTime, int state) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.realname = realname;
        this.gender = gender;
        this.idcard = idcard;
        this.registerTime = registerTime;
        this.state = state;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", realname='" + realname + '\'' +
                ", gender='" + gender + '\'' +
                ", idcard='" + idcard + '\'' +
                ", registerTime=" + registerTime +
                ", state=" + state +
                '}';
    }
}
