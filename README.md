# 关于quartz的练习

## 参考资料
https://www.quartz-scheduler.net/documentation/quartz-3.x/tutorial/


## 关键概念
Job(任务的具体执行内容)
JobDetail(JobDetails are metadata related to a Job implementation, they hold a reference to the Job you want to run and allow you to provide some additional data to your Job)
Scheduler
Trigger
Schedule
Calendar
QuartzScheduler(核心实现类,不面向用户)
StdScheduler(QuartzScheduler的proxy,面向用户)
QuartzSchedulerThread(主线程,负责fire Trigger,即在main loop中查询所有的Trigger,一步步更改Trigger的状态和提交待执行的Job)
WorkerThread(工作线程,执行Job,在worker loop中等待后执行新的Job)
JobStore(JobStore会维护Trigger实例的状态,状态枚举值参考org.quartz.impl.jdbcjobstore.Constants.STATE_XXX)



## 注意事项
1. 基于separation of concerns原则,用户期望被执行的方法被单独放在类Job,其他关于该Job的信息被放在了
2. 对于jdbc类型的持久化JobStore,JobStore在维护Trigger状态时,使用了数据库行锁来保护状态一致性的.
