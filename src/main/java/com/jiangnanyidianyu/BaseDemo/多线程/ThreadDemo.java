package com.jiangnanyidianyu.BaseDemo.多线程;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/7/3 17:06
 **/

/**
 *
 *  测试Thread中的常用方法
 *  1.start():启动当前线程;调用当前线程run()
 *  2.run():通常需要重写Thread类中的此方法,将创建的线程执行的操作声明在此方法中
 *  3.currentThread():静态方法,返回执行当前代码的线程
 *  4.getName():获取当前线程的名字
 *  5.setName():设置当前线程的名字
 *  6.yield():释放当前cpu的执行权
 *  7.join():在线程a中,调用线程b的join(),此时线程a就进入阻塞状态,直到线程b完全执行完以后,线程a才结束阻塞状态.
 *
 *  8.sleep(long millitime):让当前线程"睡眠指定"的millitime毫秒.在指定的millitime毫秒时间内,当前线程是阻塞状态
 *
 *  9.isAlive():判断当前线程是否存活
 *
 *  线程的优先级:
 *  1.
 *  MAX_PRIORITY: 10
 *  MIN_PRIORITY: 1
 *  NORM_PRIORITY: 5   -->默认
 *  2.如何获取和设置当前线程的优先级:
 *      getPriority():获取线程的优先级
 *      setPriority(int p):设置线程的优先级
 *
 *      说明:高优先级的线程要抢占低优先级线程cpu的执行权.但是值只是从概率上来讲,
 *      高优先级的线程高概率的情况下被执行.并不意味着只有当高优先级的线程执行完以后,低优先级的线程
 *      才执行
 * */
public class ThreadDemo {

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                Thread.currentThread().setName("主线程");
                int priority = Thread.currentThread().getPriority();
                System.out.println("当前线程的优先级:" + priority);
                for (int i = 0; i < 100; i++) {

//                    try {
//                        sleep(1000);    //阻塞1秒
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    if(i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i + "===================");
                    }
                }
            }
        }.start();
    }

}
