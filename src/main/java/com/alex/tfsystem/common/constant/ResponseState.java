package com.alex.tfsystem.common.constant;

public enum ResponseState {

    SUCCESS("10001","请求成功"),
    ERROR("10002","未知错误"),
    PARAM_ERROR("10004","参数错误");

    //成员变量
    private String code;
    private String msg;

    ResponseState(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
