package com.jiangnanyidianyu.Concurrency_HM;

import lombok.extern.slf4j.Slf4j;

/**
 * @author QinZhongliang
 * @date 2022年08月05日 1:59 PM
 */
@Slf4j
public class ThreadState {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @Override
            public void run(){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        log.info("t1 state:{}",t1.getState());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("t1 state:{}",t1.getState());

    }
}
