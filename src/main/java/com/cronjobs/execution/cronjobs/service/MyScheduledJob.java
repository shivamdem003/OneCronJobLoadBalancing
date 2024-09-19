package com.cronjobs.execution.cronjobs.service;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MyScheduledJob {

    //private static final Logger logger = (Logger) LoggerFactory.getLogger(MyScheduledJob.class);

    @Scheduled(cron = "0 * * * * *") // Example: runs every minute
    @SchedulerLock(name = "scheduledTaskName", lockAtLeastFor = "PT5M", lockAtMostFor = "PT30M")
    public void performTask() {
        //logger.info("Cron job executed!");
        System.out.println("Cron job executed!");
    }
}

