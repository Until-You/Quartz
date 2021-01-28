# Quartz

**定时，任务，调度框架**

引入pom依赖



### 1.任务定时调度

1. 调度器 Scheudle

   配置好触发器和任务，塞进调度器中。

2. 触发器 Trigger

   SimpleTrigger,CronTrigger。配置执行计划。

3. 任务 JobDetail

   实现Job，写具体的执行任务。



### 2.quartz的监听器

JobListener，TriggerListener，SchedulerListener



参考：https://blog.csdn.net/liu1pan2min3/article/details/51540470

