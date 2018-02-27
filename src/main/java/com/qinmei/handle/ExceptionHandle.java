package com.qinmei.handle;

import com.qinmei.domain.Result;
import com.qinmei.exception.GirlException;
import com.qinmei.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * ExceptionHandler(value = Exception.class) 捕获那种类型异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){

        // 判断是否为自定义异常
        if (e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            LOGGER.info("【系统异常】{}",e);
            // 捕获后处理,系统运行时错误，非自定义
            return ResultUtil.error(1, "未知错误");
        }
    }
}
