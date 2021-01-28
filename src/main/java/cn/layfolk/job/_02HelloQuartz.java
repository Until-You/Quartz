package cn.layfolk.job;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.GregorianCalendar;

public class _02HelloQuartz {

    public static void main(String[] args) throws SchedulerException {
         // quartz api
         //1. 调度器Scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //2. 触发器   翻译:t1 在g1这个组     每2s执行一次，执行10次就不执行了。在2021.2.2 8:30之前
        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(5))
                //.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())   //2s执行一次
                .endAt(new GregorianCalendar(2021, 2, 2, 8, 30).getTime())
                .build();

        //3. JobDetail                     标识  与上面的命名没关系
        JobDetail jobDetail = JobBuilder.newJob(_01HelloJob.class).withIdentity("job1", "group1").build();

        //4. 将JobDetail 和触发器  增加到调度器中
        scheduler.scheduleJob(jobDetail,trigger);

        //5. 启动，调度器开始工作
        scheduler.start();
    }
}
