package com.alex.tfsystem.order.controller;

import com.alex.tfsystem.common.MsgFactory;
import com.alex.tfsystem.common.ResponseVO;
import com.alex.tfsystem.common.aspect.LogAspectUtil;
import com.alex.tfsystem.common.constant.ResponseState;
import com.alex.tfsystem.order.bean.Order;
import com.alex.tfsystem.order.bean.OrderPo;
import com.alex.tfsystem.order.service.IOrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.netty.util.internal.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private IOrderService orderService;

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public ResponseVO createOrder(@RequestBody Order order){
        ResponseVO responseVO = new ResponseVO();
        //短信发送
        MsgFactory msgFactory = new MsgFactory();
        if (order.getWechatno() == null || order.getWechatno().isEmpty()
                ||order.getEmail() == null || order.getEmail().isEmpty()
                ||order.getGrade() == null || order.getGrade().isEmpty()
                ||order.getIsurgent() == null || order.getIsurgent().isEmpty()
                ||order.getJobtype() == null || order.getJobtype().isEmpty()
                ||order.getTarget() == null || order.getTarget().isEmpty()
                ||order.getDeadline() == null){
            responseVO.setResponseCode(ResponseState.PARAM_ERROR.getCode());
            responseVO.setResponseMsg(ResponseState.PARAM_ERROR.getMsg());
            return responseVO;
        }
        order.setProcstate("02");
        order.setCreatetime(new Date());
        order.setUpdatetime(new Date());
        try {
            orderService.createOrder(order);

        } catch (Exception e){
            logger.error(e.getMessage());
            responseVO.setResponseCode(ResponseState.ERROR.getCode());
            responseVO.setResponseMsg(e.getMessage());
            return responseVO;
        }
        try {
            msgFactory.sendMsgToStaff(order);
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        return responseVO;
    }

    @RequestMapping(value = "/getOrderList", method = RequestMethod.POST)
    public ResponseVO getOrderList(@RequestBody Order order){
        ResponseVO responseVO = new ResponseVO();
        List<OrderPo> orderListPo;
        if (order.getDeadlineRange() != null && !order.getDeadlineRange().isEmpty()){
            order.setDeadlineRangeStart(order.getDeadlineRange().get(0));
            order.setDeadlineRangeEnd(order.getDeadlineRange().get(1));
        }
        try{
            PageHelper.startPage(order.getPageNum(), order.getPageSize());
            orderListPo = orderService.getOrderList(order);
            Page listWithPage = (Page) orderListPo;
            responseVO.setData(listWithPage);
            return  responseVO;
        }catch (Exception e){
            e.printStackTrace();
            responseVO.setResponseCode(ResponseState.ERROR.getCode());
            responseVO.setResponseMsg(e.getMessage());
            return responseVO;
        }
    }
    
}
