package com.gy.base;

/**
 * Created by Administrator on 2017/8/15 0015.
 * 时间任务调度 -- 不继承
 */
public class SpringQuartzTask {
    private static Integer time = 0;

    public void doTask(){
        time++;
//        ApplicationLogger.monitorLogger.info("Spring第 " + time + " 次任务调度，时间戳： " + System.currentTimeMillis() );
//        ApplicationLogger.applicationLogger.info(time + "次任务调度成功");
        System.out.println(time + " test Task");

    }
}
