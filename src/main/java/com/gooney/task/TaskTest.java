package com.gooney.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component//定时业务类，被容器扫描
public class TaskTest {
    @Scheduled(fixedRate = 2000)//定时方法
    //@Scheduled(fixedDelay = 2000)
    public void task1() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(new Date()+";threadId"+Thread.currentThread());
    }
}
