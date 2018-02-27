package com.qinmei.utils;

import com.qinmei.domain.Result;

/**
 * 返回工具
 */
public class ResultUtil {

    /**
     * 请求成功返回
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("添加成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    /**
     * 请求失败返回
     * @param code
     * @param msg
     * @return
     */
    public static Result error(int code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
