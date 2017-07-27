package com.gy.util;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class JSONResponseUtil {

    /**
     * 请求成功
     * @param o 成功返回参数
     * @return
     */
    public static JSONResponse success(Object o){
        JSONResponse response = new JSONResponse();
        response.setCode(2000);
        response.setMsg("请求成功");
        response.setData(o);
        return response;
    }

    /**
     *  请求失败
     * @param o 失败返回数据
     * @return
     */
    public static JSONResponse fail(Object o){
        JSONResponse response = new JSONResponse();
        response.setCode(5000);
        response.setMsg("请求失败");
        response.setData(o);
        return response;
    }

    /**
     * 空参数请求
     * @return
     */
    public static JSONResponse paramNull(){
        JSONResponse response = new JSONResponse();
        response.setCode(4000);
        response.setMsg("空请求参数");
        return response;
    }

    /**
     * 自定义参数错误返回值
     * @param code
     * @param msg
     * @return
     */
    public static JSONResponse paramError(Integer code, String msg){
        JSONResponse response = new JSONResponse();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
