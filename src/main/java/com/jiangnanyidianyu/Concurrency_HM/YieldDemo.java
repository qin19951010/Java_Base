package com.jiangnanyidianyu.Concurrency_HM;

import lombok.extern.slf4j.Slf4j;

/**
 * @author QinZhongliang
 * @date 2022年08月05日 2:33 PM
 */
@Slf4j
public class YieldDemo {
    public static void main(String[] args) {
        Runnable task1 = ()->{
            int count = 0;
            for (;;){
                System.out.println("---t1  " + count++);
            }
        };

        Runnable task2 = ()->{
            int count = 0;
            for (;;){
                Thread.yield();
                System.out.println("-------------t2  " + count++);
            }
        };

        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");
        t1.start();
        t2.start();
    }
}
