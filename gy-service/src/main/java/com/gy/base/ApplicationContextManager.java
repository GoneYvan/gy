package com.gy.base;

import com.gy.common.ApplicationLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/27 0010.
 */
public class ApplicationContextManager {

    // 记录JVM中使用的Spring容器
    private static List<ApplicationContext> contextList = new ArrayList<>();

    /**
     * 向容器注册一个
     *
     * @param context
     */
    public static void regist(ApplicationContext context) {
        if (context == null) {
            return;
        }
        if (contextList.contains(context)) {
            return;
        }
        contextList.add(context);
    }

    /**
     * 当JVM退出时（例如Jetty关闭），调用Spring容器的Destory方法，目的是让应用完成一些后续操作。<br>
     * 该方法仅仅在JVM退出前调用，否则可能存在问题。
     */
    public static void destoryAllContext() {
        for (ApplicationContext c : contextList) {
            if (c instanceof AbstractApplicationContext) {
                ((AbstractApplicationContext) c).destroy();
                ApplicationLogger.applicationLogger.info("Close ApplicationContext! class=" + c.getClass().getName());
            }
        }
    }
}
