package com.jiangnanyidianyu.多线程.JUC;

/**
 * @author QinZhongliang
 * @date 2022年08月01日 4:10 PM
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // 实例化线程对象
        MyThread threadA = new MyThread("Thread 线程-A");
        MyThread threadB = new MyThread("Thread 线程-B");
        // 启动线程
        threadA.start();
        threadB.start();
    }

    static class MyThread extends Thread {

        private int ticket = 5;

        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖出了第 " + ticket + " 张票");
                ticket--;
            }
        }
    }
}
