package com.exmaple.learn.quartz.basic;

import com.exmaple.learn.quartz.basic.job.HelloJob;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;

public class QuartzTest {

    @Test
    public void test() {

        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // and start it off
            scheduler.start();

            // define the jobDetail and tie it to our HelloJob class
            JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .build();

            // Trigger the jobDetail to run now, and then repeat every 40 seconds
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(5)
                            .repeatForever())
                    .build();

            // Tell quartz to schedule the jobDetail using our trigger
            scheduler.scheduleJob(jobDetail, trigger);

            // prevent main thread out of main method
            System.in.read();
            scheduler.shutdown();
        } catch (SchedulerException se) {
            se.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}