package com.alex.tfsystem.demo.controller;

import com.alex.tfsystem.code.controller.CodeController;
import com.alex.tfsystem.common.ResponseVO;
import com.alex.tfsystem.common.constant.ResponseState;
import com.alex.tfsystem.demo.bean.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    Logger logger = LoggerFactory.getLogger(CodeController.class);

    @RequestMapping(value = "/createDemo",method = RequestMethod.POST)
    public ResponseVO insertDemo(@RequestBody Demo demo){
        ResponseVO responseVO = new ResponseVO();
        try{
            //do something
        }catch (Exception e){
            e.printStackTrace();
            responseVO.setResponseMsg(ResponseState.ERROR.getMsg());
            responseVO.setResponseCode(ResponseState.ERROR.getCode());
        }
        return responseVO;
    }

    @RequestMapping(value = "/updateDemo",method = RequestMethod.POST)
    public ResponseVO updateDemo(@RequestBody Demo demo){
        ResponseVO responseVO = new ResponseVO();
        try{
            //do something
        }catch (Exception e){
            e.printStackTrace();
            responseVO.setResponseMsg(ResponseState.ERROR.getMsg());
            responseVO.setResponseCode(ResponseState.ERROR.getCode());
        }
        return responseVO;
    }

    @RequestMapping(value = "/deleteDemo",method = RequestMethod.POST)
    public ResponseVO deleteDemo(@RequestBody Demo demo){
        ResponseVO responseVO = new ResponseVO();
        try{
            //do something
        }catch (Exception e){
            e.printStackTrace();
            responseVO.setResponseMsg(ResponseState.ERROR.getMsg());
            responseVO.setResponseCode(ResponseState.ERROR.getCode());
        }
        return responseVO;
    }

    @RequestMapping(value = "/getDemo",method = RequestMethod.POST)
    public ResponseVO getDemo(@RequestBody Demo demo){
        ResponseVO responseVO = new ResponseVO();
        try{
            //do something
        }catch (Exception e){
            e.printStackTrace();
            responseVO.setResponseMsg(ResponseState.ERROR.getMsg());
            responseVO.setResponseCode(ResponseState.ERROR.getCode());
        }
        return responseVO;
    }

    @RequestMapping(value = "/getDemoList",method = RequestMethod.POST)
    public ResponseVO getDemoList(@RequestBody Demo demo){
        ResponseVO responseVO = new ResponseVO();
        try{
            //do something
        }catch (Exception e){
            e.printStackTrace();
            responseVO.setResponseMsg(ResponseState.ERROR.getMsg());
            responseVO.setResponseCode(ResponseState.ERROR.getCode());
        }
        return responseVO;
    }

}
