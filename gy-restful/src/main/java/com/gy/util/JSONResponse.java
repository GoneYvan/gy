package com.gy.util;

/**
 * Created by Administrator on 2017/7/27 0027.
 * 定义返回JSON格式
 */
public class JSONResponse {

    private Integer code; // 编码
    private String msg; // 返回消息
    private Object data; // 返回数据

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
