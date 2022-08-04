package com.jiangnanyidianyu.多线程.ThreadPool.线程局部变量;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author QinZhongliang
 * @date 2022年08月02日 3:15 PM
 */
public class ThreadPoolDemo {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

     static void print(String str) {
         //打印当前线程中本地内存中本地变量的值
         System.out.println(str + " :" + threadLocal.get());
         //清除本地内存中的本地变量
         threadLocal.remove();
     }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                threadLocal.set("thread1 local variable");
                //调用打印方法
                print("thread1");
                //打印本地变量
                System.out.println("after remove : " + threadLocal.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                threadLocal.set("thread2 local variable");
                //调用打印方法
                print("thread2");
                //打印本地变量
                System.out.println("after remove : " + threadLocal.get());
            }
        }).start();
    }
}
