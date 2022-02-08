package com.ivan;

import com.ivan.diythread.ThreadTask;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hylu.ivan
 * @date 2021/11/21 下午9:28
 * @description
 */
public class Application {

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 16, 500, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    public void test() {

        while (true) {
            ThreadTask threadTask = new ThreadTask();
            executor.execute(threadTask);
        }

    }

    public static void main(String[] args) {

        Application application = new Application();
        application.test();
    }

}
