package com.jiangnanyidianyu.多线程.JUC;

/**
 * @author QinZhongliang
 * @date 2022年08月01日 5:06 PM
 */
public class ThreadSleepDemo {

    public static void main(String[] args) {
        new Thread(new MyThread("线程A", 5000)).start();
        new Thread(new MyThread("线程B", 10000)).start();
        new Thread(new MyThread("线程C", 15000)).start();
    }

    static class MyThread implements Runnable {

        /**
         * 线程名称
         */
        private String name;

        /**
         * 休眠时间
         */
        private int time;

        private MyThread(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public void run() {
            try {
                // 休眠指定的时间
                Thread.sleep(this.time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name + "休眠" + this.time + "毫秒。");
        }
    }
}
