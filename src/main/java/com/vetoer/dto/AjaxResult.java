package com.vetoer.dto;


//将所有的ajax请求返回类型，全部封装成json数据
public class AjaxResult<T> {

    //请求是否成功
    private boolean success;
    private T data;
    private String error;

    // 请求成功,返回data
    public AjaxResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }
    // 只返回提示,不一定是错误信息
    public AjaxResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

