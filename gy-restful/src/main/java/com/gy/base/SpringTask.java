package com.gy.base;

import com.gy.common.ApplicationLogger;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by Administrator on 2017/8/15 0015.
 * 时间任务调度 -- spring task
 */
public class SpringTask {
    private static Integer time = 0;

    public void doTask1(){
        time++;
        System.out.println(time + " test Task1");
    }

    public void doTask2(){
        time++;
        System.out.println(time + " test Task2");
    }
}
