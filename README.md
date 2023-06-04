# 关于quartz的练习

## 参考资料
https://www.quartz-scheduler.net/documentation/quartz-3.x/tutorial/


## 关键概念
Job(任务的具体执行内容)
JobDetail(JobDetails are metadata related to a Job implementation, they hold a reference to the Job you want to run and allow you to provide some additional data to your Job)
Scheduler
Trigger
Schedule


## 注意事项
基于separation of concerns原则,用户期望被执行的方法被单独放在类Job,其他关于该Job的信息被放在了