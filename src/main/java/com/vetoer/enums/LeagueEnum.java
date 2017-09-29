package com.vetoer.enums;

public enum LeagueEnum {
    SUCCESS(1,"加盟成功"),FAILED(-1,"加盟失败"),REGISTER_FAILED(0,"加盟用户注册失败"),REGISTER_SUCCESS(2,"加盟用户注册成功");
    private int state;
    private String stateInfo;
    private LeagueEnum(int state,String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }
    public int getState(){
        return state;
    }
    public String getStateInfo(){
        return stateInfo;
    }
    public static LeagueEnum stateOf(int index){
        for(LeagueEnum state:values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }
}
