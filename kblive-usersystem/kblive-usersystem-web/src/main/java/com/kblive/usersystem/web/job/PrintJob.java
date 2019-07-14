package com.kblive.usersystem.web.job;

import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class PrintJob implements Job {

    private static final Logger logger= Logger.getLogger(PrintJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String printTime = new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date());
        logger.info("打印工作开始:" + printTime + ", 打印: 你好-" + new Random().nextInt(100));
        System.out.println("打印工作开始:" + printTime + ", 打印: 你好-" + new Random().nextInt(100));
    }


    /**
     * 开始一个simpleSchedule()调度
     */
    public static void startSchedule() {
        try {
            // 1、创建一个JobDetail实例，指定Quartz
            JobDetail jobDetail = JobBuilder.newJob(PrintJob.class)
                    // 任务执行类
                    .withIdentity("job1_1", "jGroup1")
                    // 任务名，任务组
                    .build();


            //触发器类型
            SimpleScheduleBuilder builder = SimpleScheduleBuilder
                    // 设置执行次数
                    .repeatSecondlyForTotalCount(5);

            //CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule("0/2 * * * * ?");
            // 2、创建Trigger
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1_1", "tGroup1").startNow()
                    .withSchedule(builder)
                    .build();

            // 3、创建Scheduler
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            // 4、调度执行
            scheduler.scheduleJob(jobDetail, trigger);
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //关闭调度器
            scheduler.shutdown();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从数据库中找到已经存在的job，并重新开户调度
     */
    public static void resumeJob() {
        try {

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            JobKey jobKey = new JobKey("job1_1", "jGroup1");
            List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
            //SELECT TRIGGER_NAME, TRIGGER_GROUP FROM {0}TRIGGERS WHERE SCHED_NAME = {1} AND JOB_NAME = ? AND JOB_GROUP = ?
            // 重新恢复在jGroup1组中，名为job1_1的 job的触发器运行
            if (triggers.size() > 0) {
                for (Trigger tg : triggers) {
                    // 根据类型判断
                    if ((tg instanceof CronTrigger) || (tg instanceof SimpleTrigger)) {
                        // 恢复job运行
                        scheduler.resumeJob(jobKey);
                    }
                }
                scheduler.start();
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
