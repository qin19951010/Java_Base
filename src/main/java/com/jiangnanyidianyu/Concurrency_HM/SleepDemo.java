package com.jiangnanyidianyu.Concurrency_HM;

/**
 * 防止CPU使用率达到100%
 * 1.sleep
 * @author QinZhongliang
 * @date 2022年08月05日 2:49 PM
 */
public class SleepDemo {
    public static void main(String[] args) {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
