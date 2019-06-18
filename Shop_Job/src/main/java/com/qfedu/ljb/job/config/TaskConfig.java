package com.qfedu.ljb.job.config;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.*;

/**
 *@Author feri
 *@Date Created in 2019/6/18 14:59
 * 解决SpringTask 的单线程处理的问题
 */
public class TaskConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(createExc());
    }
    private Executor createExc(){
        //使用下面这个方式创建线程池有可能引起 OOM异常  内存溢出
        //return Executors.newFixedThreadPool(10);
        //手动创建线程池
        /**
         * 参数说明：
         * 1、线程的数量
         * 2、最多的线程数据量
         * 3、线程的空闲时间
         * 4、线程的空闲时间的单位
         * 5、存储等待的任务队列 队列：先进先出
         * */
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(10,12,100,TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10));
        return threadPoolExecutor;

    }
}
