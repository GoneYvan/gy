package com.gy.util;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class JSONResponseUtil {

    public static Integer SUCCESS = 2000; // 请求成功
    public static Integer PARAM_NULL = 4000; // 存在空参数
    public static Integer PARAM_ERROR = 4001; // 参数错误
    public static Integer FAIL = 5000; // 请求失败

    /**
     * 请求成功
     * @param o 成功返回参数
     * @return
     */
    public static JSONResponse success(Object o){
        JSONResponse response = new JSONResponse();
        response.setCode(SUCCESS);
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
        response.setCode(FAIL);
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
        response.setCode(PARAM_NULL);
        response.setMsg("存在空请求参数");
        return response;
    }

    /**
     * 自定义参数错误返回值
     * @param code
     * @param msg
     * @return
     */
    public static JSONResponse error(Integer code, String msg){
        JSONResponse response = new JSONResponse();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
