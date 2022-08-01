package com.jiangnanyidianyu.BaseDemo.多线程.JUC;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/7/4 17:36
 **/

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *  解决线程安全问题的方式三: Lock锁   ---- JDK5.0新增
 *
 *  1. 面试题: synchronized 和 Lock的异同
 *   相同: 二者都可以解决线程安全问题
 *   不同:
 *
 *
 *
 * */

class Window implements Runnable{

    private int ticket = 100;

    //fair参数默认为false, 当为true时 线程之间抢占资源是相对公平的,一个线程抢占后结束其它线程再进来,不会出现线程1抢占结束再次被抢占的问题
    //1.实例化 ReentrantLock
    private ReentrantLock lock = new ReentrantLock(false);

    @Override
    public void run() {
        while(true){
            try{

                //2.调用lock()方法
                lock.lock();
                if(ticket > 0){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": 售票,票号为: " + ticket);
                    ticket--;
                }else
                {
                    break;
                }
            }finally {
                //3. 调用解锁方法 unlock()
                lock.unlock();
            }
        }
    }
}

public class Lock {
    public static void main(String[] args) {
        Window win = new Window();
        Thread t1 = new Thread(win);
        Thread t2 = new Thread(win);
        Thread t3 = new Thread(win);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
