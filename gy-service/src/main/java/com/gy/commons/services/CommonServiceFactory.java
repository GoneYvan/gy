package com.gy.commons.services;

import com.gy.base.ServiceLocator;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class CommonServiceFactory extends ServiceLocator{

    public static UserService getUserService(){
        return (UserService) getBean("userService");
    }
}
