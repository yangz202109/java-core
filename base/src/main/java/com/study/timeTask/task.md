# 定时任务的使用
## 1.Timer
Timer 是 JDK 自带的定时任务执行类,无论任何项目都可以直接使用 Timer 来实现定时任务,所以 Timer 的优点就是使用方便
 ```java
  public class MyTimerTask {
    public static void main(String[] args) {
        // 定义一个任务
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Run timerTask：" + new Date());
            }
        };
        // 计时器
        Timer timer = new Timer();
        // 添加执行任务（延迟 1s 执行，每 3s 执行一次）
        timer.schedule(timerTask, 1000, 3000);
    }
}
```
## 2.ScheduledExecutorService
ScheduledExecutorService 也是 JDK 1.5 自带的 API,我们可以使用它来实现定时任务的功能,  
也就是说 ScheduledExecutorService 
可以实现 Timer 类具备的所有功能,并且它可以解决了 Timer 类存在的所有问题。

```java
public class MyScheduledExecutorService {
    public static void main(String[] args) {
        // 创建任务队列
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(10); // 10 为线程数量
        // 执行任务
        scheduledExecutorService.scheduleAtFixedRate(() ->  
                System.out.println("Run Schedule：" + new Date()), 1, 3, TimeUnit.SECONDS); // 1s 后开始执行，每 3s 执行一次
    }
}
```
## 3.Spring Task
如果使用的是 Spring 或 Spring Boot 框架，可以直接使用 Spring Framework 自带的定时任务，使用上面两种定时任务的实现方式，很难实现设定了具体时间的定时任务,  
比如当我们需要每周五来执行某项任务时，但如果使用 Spring Task 就可轻松的实现此需求。
 ### 1. 开启定时任务
  ```java
   @SpringBootApplication
   @EnableScheduling // 开启定时任务
   public class DemoApplication {
        // do something
   }
  ```
 ### 2. 添加定时任务 
  ```java
    @Component // 把此类托管给 Spring，不能省略
    public class TaskUtils {
        // 添加定时任务
        @Scheduled(cron = "59 59 23 0 0 5") // cron 表达式，每周五 23:59:59 执行
        public void doTask(){
        System.out.println("我是定时任务~");
        }
    }
```

## 4.分布式任务
 ### ① ZSet 实现方式