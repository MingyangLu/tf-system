package com.alex.tfsystem.common;

import com.alex.tfsystem.common.constant.ResponseState;
import org.springframework.ui.ModelMap;

public class ResponseVO extends ModelMap {

    public ResponseVO(){
        setResponseCode(ResponseState.SUCCESS.getCode());
        setResponseMsg(ResponseState.SUCCESS.getMsg());
    }

    public ResponseVO(String responseCode){
        setResponseCode(responseCode);
    }

    public ResponseVO(String responseCode,String responseMsg){
        setResponseCode(responseCode);
        setResponseMsg(responseMsg);
    }

    public String getResponseCode(){
        return ((String) get("resposeCode"));
    }

    public ResponseVO setResponseCode(String responseCode){
        put ("resposeCode",responseCode);
        return this;
    }

    public String getResponseMsg(){
        return ((String) get("resposeMsg"));
    }

    public ResponseVO setResponseMsg(String resposeMsg){
        put ("resposeMsg",resposeMsg);
        return this;
    }

    public ResponseVO setData(Object data){
        put("data",data);
        return this;
    }

    public Object getData(){
        return get("data");
    }



}
