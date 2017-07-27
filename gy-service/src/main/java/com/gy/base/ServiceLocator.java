package com.gy.base;

import com.gy.common.ApplicationLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class ServiceLocator {

    protected static ApplicationContext context;

    static {
        try {
            context = new ClassPathXmlApplicationContext(new String[]{"classpath*:/META-INF/spring/spring_*.xml"});
            ApplicationContextManager.regist(context);
        } catch (RuntimeException e) {
            ApplicationLogger.applicationLogger.error("", e);
            throw e;
        }
    }

    public static boolean hasInitFinish() {
        return context != null;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static Object getBean(String beanId) {
        return context.getBean(beanId);
    }
}
