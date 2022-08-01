package com.jiangnanyidianyu.多线程.JUC;

/**
 * @author QinZhongliang
 * @date 2022年08月01日 4:17 PM
 */
public class RunnableDemo {

    public static void main(String[] args) {
        // 实例化线程对象
        Thread threadA = new Thread(new MyThread(), "Runnable 线程-A");
        Thread threadB = new Thread(new MyThread(), "Runnable 线程-B");
        // 启动线程
        threadA.start();
        threadB.start();
    }

    static class MyThread implements Runnable {

        private int ticket = 5;

        @Override
        public void run() {
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖出了第 " + ticket + " 张票");
                ticket--;
            }
        }
    }
}
