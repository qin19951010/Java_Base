package com.jiangnanyidianyu.Concurrency_HM;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author QinZhongliang
 * @date 2022年08月05日 2:04 PM
 */
@Slf4j
public class ThreadInterrupte {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                log.info("enter sleep...");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    log.info("wake up....");
                    e.printStackTrace();
                }
            }
        };
        t1.start();

        TimeUnit.SECONDS.sleep(5);
        log.debug("interrupt...");
        t1.interrupt();
    }
}
