package com.kafeitoo.blog.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.TriggerUtils;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class QuickScheduleTasks {

    @Scheduled(cron = "0 0/1 * * * ?")
    public void testCron() {
        log.info("{}", LocalDateTime.now());
    }

    public static void main(String[] args) throws InterruptedException, ParseException {
        CronTriggerImpl cronTriggerImpl = new CronTriggerImpl();
        cronTriggerImpl.setCronExpression("0 0/1 * * * ?");//这里写要准备猜测的cron表达式
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        calendar.add(Calendar.YEAR, 2);//把统计的区间段设置为从现在到2年后的今天（主要是为了方法通用考虑，如那些1个月跑一次的任务，如果时间段设置的较短就不足20条)
        List<Date> dates = TriggerUtils.computeFireTimesBetween(cronTriggerImpl, null, now, calendar.getTime());//这个是重点，一行代码搞定~~
        System.out.println(dates.size());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(int i =0;i < dates.size();i ++){
            if(i >19){//这个是提示的日期个数
                break;
            }
            System.out.println(dateFormat.format(dates.get(i)));
        }
    }
}
