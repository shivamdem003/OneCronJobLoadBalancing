package com.cronjobs.execution.cronjobs.service;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MyScheduledJob {

    //private static final Logger logger = (Logger) LoggerFactory.getLogger(MyScheduledJob.class);

    @Scheduled(cron = "0 * * * * *") // Example: runs every minute
    @SchedulerLock(name = "scheduledTaskName", lockAtLeastFor = "PT5M", lockAtMostFor = "PT30M")
    public void performTask() {
        try {
            // Your task logic here
            System.out.println("Cron job executed!");
        } catch (Exception e) {
            // Log the exception
            System.err.println("Error executing cron job: " + e.getMessage());
        }
    }
}

