package com.alex.tfsystem.order.controller;

import com.alex.tfsystem.common.MsgFactory;
import com.alex.tfsystem.common.ResponseVO;
import com.alex.tfsystem.common.aspect.LogAspectUtil;
import com.alex.tfsystem.common.constant.ResponseState;
import com.alex.tfsystem.order.bean.Order;
import com.alex.tfsystem.order.bean.OrderPo;
import com.alex.tfsystem.order.service.IOrderService;
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
        List<Order> orderList;
        List<OrderPo> orderListPo = new ArrayList<>();
        if (order.getDeadlineRange() != null && !order.getDeadlineRange().isEmpty()){
            order.setDeadlineRangeStart(order.getDeadlineRange().get(0));
            order.setDeadlineRangeEnd(order.getDeadlineRange().get(1));
        }
        try{
            orderList = orderService.getOrderList(order);
            // 对orderList的数据类型格式化
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           for(Order orderFm: orderList){
               OrderPo orderPo = new OrderPo();
               BeanUtils.copyProperties(orderFm,orderPo);
               String createtime = simpleDateFormat.format(orderFm.getCreatetime());
               String updatetime = simpleDateFormat.format(orderFm.getUpdatetime());
               String deadline = simpleDateFormat.format(orderFm.getDeadline());
               orderPo.setCreatetime(createtime);
               orderPo.setUpdatetime(updatetime);
               orderPo.setDeadline(deadline);
               orderListPo.add(orderPo);
           }
            responseVO.setData(orderListPo);
            return  responseVO;
        }catch (Exception e){
            responseVO.setResponseCode(ResponseState.ERROR.getCode());
            responseVO.setResponseMsg(e.getMessage());
            return responseVO;
        }
    }
    
}
