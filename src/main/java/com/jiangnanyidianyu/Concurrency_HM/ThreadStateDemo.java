package com.jiangnanyidianyu.Concurrency_HM;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 线程状态
 * @author QinZhongliang
 * @date 2022年08月05日 5:22 PM
 */
@Slf4j
public class ThreadStateDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                log.info("running");
            }
        };

        Thread t2 = new Thread("t2"){
            @Override
            public void run() {
                while (true){//runnable

                }
            }
        };
        t2.start();

        Thread t3 = new Thread("t3"){
            @Override
            public void run() {
                log.info("running...");
            }
        };
        t3.start();

        Thread t4 = new Thread("t4"){
            @Override
            public void run() {
                synchronized (ThreadStateDemo.class){
                    try {
                        TimeUnit.SECONDS.sleep(1000);//timed_waiting
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t4.start();

        Thread t5 = new Thread("t5"){
            @Override
            public void run() {
                try {
                    t2.join();//waiting
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t5.start();

        Thread t6 = new Thread("t6"){
            @Override
            public void run() {
                synchronized (ThreadStateDemo.class){
                    try {
                        TimeUnit.SECONDS.sleep(1000);//timed_waiting
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t6.start();

        log.info("t1 state {}",t1.getState());
        log.info("t2 state {}",t2.getState());
        log.info("t3 state {}",t3.getState());
        log.info("t4 state {}",t4.getState());
        log.info("t5 state {}",t5.getState());
        log.info("t6 state {}",t6.getState());
    }
}
