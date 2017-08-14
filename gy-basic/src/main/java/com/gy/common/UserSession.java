package com.gy.common;

/**
 * Created by Administrator on 2017/8/14 0014.
 *
 */
public class UserSession {
    private static ThreadLocal<UserSession> sessionThreadLocal = new ThreadLocal<>();
    private Integer userId;

    public static UserSession getCurrent() {
        return sessionThreadLocal.get();
    }

    public static void setCurrent(UserSession staffUserSession) {
        sessionThreadLocal.set(staffUserSession);

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

