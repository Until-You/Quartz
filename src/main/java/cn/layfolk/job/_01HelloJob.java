package cn.layfolk.job;

import org.quartz.*;

import java.time.LocalDateTime;

/**
 * Job 任务
 */
public class _01HelloJob  implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();
        JobKey key = jobDetail.getKey();
        System.out.println(key.getName());
        System.out.println(key.getGroup());
        System.out.println("hello job exec !"+ LocalDateTime.now());

    }
}
