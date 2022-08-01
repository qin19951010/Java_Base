package com.jiangnanyidianyu.BaseDemo.多线程;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/7/3 16:39
 **/

/**
 *  多线程的创建,方式一:继承于Thread类
 *      1.创建一个继承于Thread类的子类
 *      2.重写Thread类的run()
 *      3.创建Thread类的子类对象
 *      4.通过此对象调用start()
 *
 *      例子:遍历100以内的所有偶数
 * */

//1.创建一个继承于Thread类的子类
class MyThread extends Thread{

    //2.重写Thread类的run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class Tread_01 {
    public static void main(String[] args) {

        //3.创建Thread类子类的对象
        MyThread t1 = new MyThread();

        //4.通过此对象调用start(): ①启动当前线程 ②调用当前线程的run()
        t1.start();
        //t1.run();
        /**
         *  直接调run()
         *  这种方式没有多分出来线程
         *
         * */

        //再启动一个线程,遍历100以内的偶数.不可以让已经start()的线程去执行.会报java.lang.IllegalThreadStateException异常
        //t1.start();
        MyThread t2 = new MyThread();
        t2.start();

        System.out.println("hello");

        //如下的操作仍然是在main线程中执行
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i + "===================");
            }
        }


        //通过创建Thread类的匿名子类的方式
        new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 100; i++) {
                    if(i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i + "===================");
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 100; i++) {
                    if(i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i + "===================");
                    }
                }
            }
        }.start();

    }
}
