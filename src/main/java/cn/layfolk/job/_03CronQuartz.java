package cn.layfolk.job;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class _03CronQuartz {

    public static void main(String[] args) throws SchedulerException {
         // quartz api
         //1. 调度器Scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //2. 触发器
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * 2 2 ？"))  //cron表达式   秒 分 小时 日 月 星期
                .build();

        //3. JobDetail                     标识  与上面的命名没关系
        JobDetail jobDetail = JobBuilder.newJob(_01HelloJob.class).withIdentity("job1", "group1").build();

        //4. 将JobDetail 和触发器  增加到调度器中
        scheduler.scheduleJob(jobDetail,trigger);

        //5. 启动，调度器开始工作
        scheduler.start();
    }
}
