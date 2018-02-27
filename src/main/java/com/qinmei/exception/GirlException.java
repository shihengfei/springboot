package com.qinmei.exception;

import com.qinmei.enums.ResultEnum;

/**
 * 自定义异常处理
 */
public class GirlException extends RuntimeException{

    // 调用父类
    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    // 消息状态
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
