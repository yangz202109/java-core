package com.study.timeTask;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author yangz
 * @code 2024/3/21 - 10:34
 * ScheduledExecutorService 也是 JDK 1.5 自带的 API，我们可以使用它来实现定时任务的功能，
 * 也就是说 ScheduledExecutorService 可以实现 Timer 类具备的所有功能，并且它可以解决了 Timer 类存在的所有问题。
 * 在单机生产环境下建议使用 ScheduledExecutorService 来执行定时任务，
 * 并且使用 ScheduledExecutorService 来执行任务，不会造成任务间的相互影响
 */
public class MyScheduledExecutorService {
    public static void main(String[] args) {
        // 创建任务队列
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(3); // 3 为线程数量

        // 执行任务
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("Run Schedule 1: " + LocalDateTime.now());
        }, 1, 3, TimeUnit.SECONDS); // 1s 后开始执行，每 3s 执行一次

        // 执行任务
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("Run Schedule 2:" + LocalDateTime.now());
        }, 1, 3, TimeUnit.SECONDS); // 1s 后开始执行，每 3s 执行一次
    }
}
