package com.example.ymusic.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;

@Slf4j
public class TestUtils {

    public static void main(String[] args) throws InterruptedException {
        final TimeInterval timer = new TimeInterval();

        MyThread myThread = new MyThread();
        timer.start("1");
        myThread.start();
        MyThread2 myThread2 = new MyThread2();
        timer.start("2");
        myThread2.start();
        MyThread.sleep(1000);
        MyThread2.sleep(1000);
        log.info("Timer 1 took {} ms", timer.intervalMs("1"));
        log.info("Timer 2 took {} ms", timer.intervalMs("2"));
    }

    //继承Thread类实现run方法
    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                log.info("{}",i);
            }

        }
    }

    static class MyThread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }

        }
    }

    public void testTime(){
        final TimeInterval timer = new TimeInterval();

        timer.start("1");
        ThreadUtil.sleep(800);
        timer.start("2");
        ThreadUtil.sleep(900);

        Console.log("Timer 1 took {} ms", timer.intervalMs("1"));
        Console.log("Timer 2 took {} ms", timer.intervalMs("2"));
    }

}
