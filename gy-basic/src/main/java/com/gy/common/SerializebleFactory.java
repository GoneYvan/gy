package com.gy.common;

import java.io.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/27 0027.
 * 对象的序列化和反序列化
 */
public class SerializebleFactory {


    /**
     * 将对象转化为字节数组
     * @param obj
     * @return
     */
    public static byte[] getObjectBytes(Object obj){
        byte[] bytes = null;
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);
            bytes = bo.toByteArray();
            bo.close();
            oo.close();
        } catch (Exception e) {
            ApplicationLogger.monitorLogger.info("序列化失败：" + e.getMessage());
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * 将字节数组转化为对象
     * @param bytes
     * @return
     */
    public static Object getBytesObject(byte[] bytes){
        Object obj = null;
        try {
            // bytearray to object
            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
            ObjectInputStream oi = new ObjectInputStream(bi);
            obj = oi.readObject();
            bi.close();
            oi.close();
        } catch (Exception e) {
            ApplicationLogger.monitorLogger.info("反序列化失败：" + e.getMessage());
            e.printStackTrace();
        }
        return obj;
    }

}

