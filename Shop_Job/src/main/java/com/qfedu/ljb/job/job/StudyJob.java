package com.qfedu.ljb.job.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 *@Author feri
 *@Date Created in 2019/6/18 14:22
 */
public class StudyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("学习使我快乐！");
    }
}
