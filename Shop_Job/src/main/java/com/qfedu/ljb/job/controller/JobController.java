package com.qfedu.ljb.job.controller;

import com.qfedu.ljb.job.job.StudyJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/6/18 14:23
 */
@RestController
public class JobController {


    @GetMapping("job/start.do")
    public String start(String cron) throws SchedulerException {
//        Trigger trigger=TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
//        JobDetail jobDetail=JobBuilder.newJob(StudyJob.class).build();
//        scheduler.scheduleJob(jobDetail,trigger);
        return "OK";
    }
}
