package com.alex.tfsystem.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
    利用切面把日志作用于controller
 */
@Aspect
@Component
public class LogAspectUtil<BaseEntry> {

    private static final Logger logger = LoggerFactory.getLogger(LogAspectUtil.class);

    /*
       定义切入点
     */
    @Pointcut (value="execution(* com.alex.tfsystem.*.*.*.*(..))")
    public void webLog(){
    }

    /*
        前置通知
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        logger.info(""+joinPoint.getSignature().getName());
        logger.info(""+joinPoint.getStaticPart());
    }

    /*
        后置通知
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object ret){

    }
}
