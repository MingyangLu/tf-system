package com.alex.tfsystem.code.controller;

import com.alex.tfsystem.code.bean.Code;
import com.alex.tfsystem.code.bean.CodeItem;
import com.alex.tfsystem.code.service.ICodeService;
import com.alex.tfsystem.common.ResponseVO;
import com.alex.tfsystem.common.constant.ResponseState;
import com.alex.tfsystem.common.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@RestController
@RequestMapping("code")
public class CodeController {

    Logger logger = LoggerFactory.getLogger(CodeController.class);

    @Resource
    private ICodeService codeService;

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping(value = "/getCodeList",method = RequestMethod.POST)
    public ResponseVO getCodeList(@RequestBody Code code){
        ResponseVO responseVO = new ResponseVO();
        try{
            responseVO.setData(codeService.getCodeList(code));
        }catch (Exception e){
            e.printStackTrace();
            responseVO.setResponseMsg(ResponseState.ERROR.getMsg());
            responseVO.setResponseCode(ResponseState.ERROR.getCode());
        }
        return responseVO;
    }

    @RequestMapping(value = "/getCodeListTest1",method = RequestMethod.POST)
    public void getCodeListTest(@RequestBody Code code) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(50);
        CountDownLatch cdlEnd = new CountDownLatch(50);
        long startTime = System.currentTimeMillis();
        logger.error("开始"+startTime);
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    cdl.countDown();
                    cdl.await();
                    logger.error("工作线程开启：" + Thread.currentThread() + ",当前时间:" + System.currentTimeMillis());
                    List<CodeItem> result = codeService.getCodeList(code);
                    if (null == result) {
                        logger.error("工作线程失败：" + Thread.currentThread());
                    }
                    logger.error("工作线程结束：" + Thread.currentThread() + ",当前时间:" + System.currentTimeMillis());
                    cdlEnd.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        cdlEnd.await();
        logger.error("耗时："+(System.currentTimeMillis()-startTime));
    }

    @RequestMapping(value = "/getCodeListTestWithLock",method = RequestMethod.POST)
    public void getCodeListTestWithLock(@RequestBody Code code) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(50);
        CountDownLatch cdlEnd = new CountDownLatch(50);
        long startTime = System.currentTimeMillis();
        logger.error("开始"+startTime);
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    cdl.countDown();
                    cdl.await();
                    logger.error("工作线程开启：" + Thread.currentThread() + ",当前时间:" + System.currentTimeMillis());
                    List<CodeItem> result = codeService.getCodeListWithLock(code);
                    if (null == result) {
                        logger.error("工作线程失败：" + Thread.currentThread());
                    }
                    logger.error("工作线程结束：" + Thread.currentThread() + ",当前时间:" + System.currentTimeMillis());
                    cdlEnd.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        cdlEnd.await();
        logger.error("耗时："+(System.currentTimeMillis()-startTime));
    }
}
