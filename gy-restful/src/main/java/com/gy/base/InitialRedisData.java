package com.gy.base;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class InitialRedisData implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(contextRefreshedEvent.getApplicationContext().getParent() == null){
            //避免出现2个容器，调用2次onApplicationEvent方法
//            System.out.println("initialization ..................");
        }
    }
}
