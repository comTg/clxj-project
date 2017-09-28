package com.vetoer.enums;

public enum UserEnum {
    SUCCESS(1,"执行成功"),HAVE_REGISTER(2,"手机号已注册"),IS_EXISTS(0,"手机号未注册"),FAILED(-1,"密码错误"),INNER_ERROR(-2,"系统异常");
    private int state;
    private String stateInfo;
    private UserEnum(int state,String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }
    public int getState(){
        return state;
    }
    public String getStateInfo(){
        return stateInfo;
    }
    public static UserEnum stateOf(int index){
        for(UserEnum state:values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }
}
