package com.qinmei.enums;

/**
 * 自定义异常枚举
 */
public enum ResultEnum {

    UNKNOW_ERROR(1,"未知错误"),
    SUCCESS(0,"成功"),
    AGIRL(101,"小学"),
    BGIRL(102,"初中")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
