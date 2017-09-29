package com.vetoer.dto;

import com.vetoer.entity.Thicket;
import com.vetoer.enums.LeagueEnum;

public class LeagueExecution {
    private int id;
    // 用户手机号码
    private String phone;
    // 执行之后的状态
    private int state;
    // 执行之后的结果
    private String stateInfo;
    // 用户操作成功后需要返回的丛林或闲居对象
    private Thicket thicket;
    // 加盟成功
    public LeagueExecution(LeagueEnum leagueEnum,Thicket thicket){
        this.state = leagueEnum.getState();
        this.stateInfo = leagueEnum.getStateInfo();
        this.thicket = thicket;
    }
    public LeagueExecution(String phone,LeagueEnum leagueEnum, Thicket thicket) {
        this.phone = phone;
        this.state = leagueEnum.getState();
        this.stateInfo = leagueEnum.getStateInfo();
        this.thicket = thicket;
    }

    public LeagueExecution(int id, String phone, LeagueEnum leagueEnum, Thicket thicket){
        this.id = id;
        this.phone = phone;
        this.state = leagueEnum.getState();
        this.stateInfo = leagueEnum.getStateInfo();
        this.thicket = thicket;
    }
    // 其它结果
    public LeagueExecution(String phone,LeagueEnum leagueEnum){
        this.phone = phone;
        this.state = leagueEnum.getState();
        this.stateInfo = leagueEnum.getStateInfo();
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

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Thicket getThicket() {
        return thicket;
    }

    public void setThicket(Thicket thicket) {
        this.thicket = thicket;
    }

    @Override
    public String toString() {
        return "LeagueExecution{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", thicket=" + thicket +
                '}';
    }
}
