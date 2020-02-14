package com.gooney.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;


@Component
@Async
public class TaskAsync {
    public void task1() throws InterruptedException {
        long begin=System.currentTimeMillis();
        Thread.sleep(1000);
        long end=System.currentTimeMillis();
        System.out.println("任务1:"+(end-begin));
    }
    public void task2() throws InterruptedException {
        long begin=System.currentTimeMillis();
        Thread.sleep(2000);
        long end=System.currentTimeMillis();
        System.out.println("任务2:"+(end-begin));
    }
    public void task3() throws InterruptedException {
        long begin=System.currentTimeMillis();
        Thread.sleep(3000);
        long end=System.currentTimeMillis();
        System.out.println("任务3:"+(end-begin));
    }

    public Future<String> task4() throws InterruptedException {
        long begin=System.currentTimeMillis();
        Thread.sleep(3000);
        long end=System.currentTimeMillis();
        System.out.println("任务4:"+(end-begin));
        return new AsyncResult<>("任务4");
    }
    public Future<String> task5() throws InterruptedException {
        long begin=System.currentTimeMillis();
        Thread.sleep(2000);
        long end=System.currentTimeMillis();
        System.out.println("任务5:"+(end-begin));
        return new AsyncResult<>("任务5");
    }
    public Future<String> task6() throws InterruptedException {
        long begin=System.currentTimeMillis();
        Thread.sleep(1000);
        long end=System.currentTimeMillis();
        System.out.println("任务6:"+(end-begin));
        return new AsyncResult<>("任务6");
    }
}
