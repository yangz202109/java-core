package com.study.callback;

/**
 * @author yangz
 * @createTime 2024/1/12 - 16:36
 * 回调函数是一种特殊类型的函数,它作为参数传递给另一个函数，
 * 并且在特定事件发生或条件满足时由调用者函数调用。回调函数允许程序在特定事件发生时执行自定义的逻辑。
 * 回调函数通常用于异步编程或事件驱动编程中，可以用来处理异步操作的结果、处理用户交互、处理事件触发等。
 * 回调函数的一般工作流程:
 * 1.定义回调函数:首先，你需要定义一个函数，该函数将作为回调函数。回调函数可以接受参数，并执行特定的逻辑。
 * 2.传递回调函数:接下来，你需要将回调函数作为参数传递给另一个函数（通常是一个异步函数或事件处理函数），以便在特定事件发生时调用。
 * 3.触发回调:当特定事件发生或条件满足时，调用者函数将调用传递的回调函数，并传递相应的参数。回调函数将执行你定义的逻辑，并返回结果给调用者函数。
 * 4.处理回调结果:一旦回调函数被调用并完成逻辑，调用者函数可以处理回调函数的结果，例如获取异步操作的结果或执行进一步的操作。
 * 回调函数的使用可以提高代码的灵活性和可扩展性，允许不同部分的代码进行解耦，从而使程序更加模块化和可重用。
 */
// 回调接口
interface Callback {
    void onSuccess(String result);
    void onFailure(String error);
}

// 执行某个操作的类
class Worker {
    void doWork(Callback callback) {
        // 模拟异步操作
        new Thread(() -> {
            try {
                // 执行操作
                Thread.sleep(2000);
                // 操作成功，调用回调函数的onSuccess方法
                callback.onSuccess("Operation completed successfully");
            } catch (InterruptedException e) {
                // 操作失败，调用回调函数的onFailure方法
                callback.onFailure("Operation failed: " + e.getMessage());
            }
        }).start();
    }
}

// 使用回调函数的示例类
public class CallbackDemo {
    public static void main(String[] args) {
        Worker worker = new Worker();

        // 创建回调对象
        Callback callback = new Callback() {
            @Override
            public void onSuccess(String result) {
                System.out.println("Success: " + result);
            }

            @Override
            public void onFailure(String error) {
                System.out.println("Failure: " + error);
            }
        };

        // 调用doWork方法，并传递回调对象
        worker.doWork(callback);

        // 程序继续执行其他操作...
        System.out.println("Program execution continues...");

    }
}
