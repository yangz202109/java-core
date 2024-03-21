package com.study.timeTask;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author yangz
 * @code 2024/3/21 - 10:17
 * Timer 是 JDK 自带的定时任务执行类
 * Timer 类实现定时任务的优点是方便，因为它是 JDK 自定的定时任务，
 * 但缺点是任务如果执行时间太长或者是任务执行异常，会影响其他任务调度，所以在生产环境下建议谨慎使用。
 */
public class MyTimerTask {

    public static void main(String[] args) {
        // 定义一个任务
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Run timerTask 1：" + LocalDateTime.now());
            }
        };

        // 定义任务 2
        TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Run timerTask 2：" + LocalDateTime.now());
            }
        };


        // 计时器
        Timer timer = new Timer();
        /*
         * 添加执行任务（延迟 1s 执行，每 3s 执行一次）
         * 参数：
         * task ——要安排的任务。
         * delay – 执行任务之前的延迟（以毫秒为单位）。
         * period – 连续任务执行之间的时间（以毫秒为单位）
         */
        timer.schedule(timerTask, 1000, 3000);
        timer.schedule(timerTask2,1000, 3000);
    }

}
