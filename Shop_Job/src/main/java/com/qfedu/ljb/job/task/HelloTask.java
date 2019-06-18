package com.qfedu.ljb.job.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *@Author feri
 *@Date Created in 2019/6/18 14:50
 */
@Component
public class HelloTask {
    //每天下午的2：30和3点30之后每隔3秒 喊一次 到
    @Scheduled(cron = "0/3 30/1 14,15 * * ?")
    public void task1(){
        System.out.println("下午犯困："+System.currentTimeMillis());
    }
}
