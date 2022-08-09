package com.jiangnanyidianyu.Concurrency_HM;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author QinZhongliang
 * @date 2022年08月05日 3:00 PM
 */
@Slf4j
public class JoinDemo02 {
    static int i = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    log.info("t1线程开始");
                    TimeUnit.SECONDS.sleep(1);
                    i++;
                    log.info("t1线程结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        t1.join();
        log.info("主线程中i:{}",i);

    }
}
