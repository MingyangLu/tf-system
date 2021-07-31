package com.alex.tfsystem.price.controller;

import com.alex.tfsystem.common.ResponseVO;
import com.alex.tfsystem.common.constant.ResponseState;
import com.alex.tfsystem.price.bean.Price;
import com.alex.tfsystem.price.service.IPriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "价格计算")
@RestController
@RequestMapping("price")
public class PriceController {

    @Resource
    private IPriceService priceService;

    @ApiOperation(value = "根据作业信息计算所需价格")
    @RequestMapping(value = "/getPrice",method = RequestMethod.POST)
    public ResponseVO getPrice(@RequestBody Price price){
        ResponseVO responseVO = new ResponseVO();
        try{
            responseVO.setData(priceService.getPrice(price));
            responseVO.setResponseMsg(ResponseState.SUCCESS.getMsg());
            responseVO.setResponseCode(ResponseState.SUCCESS.getCode());
            return responseVO;
        }catch (Exception e){
            responseVO.setResponseMsg(ResponseState.ERROR.getMsg());
            responseVO.setResponseCode(ResponseState.ERROR.getCode());
            return responseVO;
        }
    }
}
