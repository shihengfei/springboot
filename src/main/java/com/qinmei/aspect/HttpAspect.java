package com.qinmei.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * AOP 拦截器
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 切面，公共
     */
    @Pointcut("execution(public * com.qinmei.controller.GirlController.*(..))")
    public void logg(){
    }

    /**
     * 方法前拦截，日志记录请求信息
     */
    @Before("logg()")
    public void log(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 请求方式
        LOGGER.info("method={}",request.getMethod());

        // 请求url
        LOGGER.info("url={}",request.getRequestURL());

        // 请求 ip
        LOGGER.info("ip={}",request.getRemoteAddr());

        // 类方法
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

    }

    /**
     * 方法后拦截
     */
    @After("logg()")
    public void lo(){
        LOGGER.info("2222222222222");
    }

    /**
     * 返回前端数据
     * @param o
     */
    @AfterReturning(returning = "o",pointcut = "logg()")
    public void after(Object o){
        LOGGER.info("response={}",o);
    }


}
