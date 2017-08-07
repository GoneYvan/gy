package com.gy.util;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class CommonCheckFactory {

    /**
     * 判断整形结果是否成功（非空非0）
     * @param result
     * @return true 结果成功
     */
    public static boolean checkSuccess(Integer result){
        if(result != null && result > 0){
            return true;
        }
        return false;
    }

    /**
     * 判断对象是否为空
     * @param objects
     * @return true 对象为空值
     */
    public static boolean checkObjectNull(Object... objects){
        if(objects == null){
            return true;
        }
        for(Object o : objects){
            if(o == null){
                return true;
            }
        }
        return false;
    }


}
