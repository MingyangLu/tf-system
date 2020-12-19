package com.alex.tfsystem.code.controller;

import com.alex.tfsystem.code.bean.Code;
import com.alex.tfsystem.code.bean.CodeItem;
import com.alex.tfsystem.code.service.ICodeService;
import com.alex.tfsystem.common.ResponseVO;
import com.alex.tfsystem.common.constant.ResponseState;
import com.alex.tfsystem.common.utils.RedisUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("code")
public class CodeController {

    @Resource
    private ICodeService codeService;

    @Resource
    private RedisUtil redisUtil;
    @RequestMapping(value = "/getCodeList",method = RequestMethod.POST)
    public ResponseVO getCodeList(@RequestBody Code code){
        ResponseVO responseVO = new ResponseVO();
        try{
            if(redisUtil.hasKey(code.getCodeName())){
                responseVO.setData(redisUtil.get(code.getCodeName()));
            }else {
                List<CodeItem>  codeList = new ArrayList<CodeItem>();
                codeList = codeService.getCodeList(code);
                redisUtil.set(code.getCodeName(),codeList,10000);
                responseVO.setData(codeList);
            }
             return responseVO;
        }catch (Exception e){
            responseVO.setResponseMsg(ResponseState.ERROR.getMsg());
            responseVO.setResponseCode(ResponseState.ERROR.getCode());
            return responseVO;
        }
    }
}
