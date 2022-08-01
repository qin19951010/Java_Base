package com.jiangnanyidianyu.BaseDemo.多线程;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/7/3 23:37
 **/
/**
 *  Thread类及其子类的对象来表示线程,在它的一个完整的生命周期中通常要经历如下的五种状态
 *      新建: 当一个Thread类或其子类的对象被声明并创建时,新生的线程对象处于新建状态
 *      就绪: 处于新建状态的线程被Start()后,将进入线程队列等待CPU时间片,此时它具备了运行的条件,只是没分配到CPU资源
 *      运行: 当就绪的线程被调度并获得CPU资源时,便进入运行状态,run()方法定义了线程的操作和功能
 *      阻塞: 在某种特殊情况下,被人为挂起或执行输入输出操作时,让出CPU并临时终止自己的执行,进入阻塞状态
 *      死亡: 线程完成了它的全部工作或线程被提前强制性地终止或出现异常导致结束
 *
 *
 *                                         -----  _阻塞   ←---
 *                         1.sleep()时间到 /                   \       1. sleep(long time)
 *                         2.join结束     /                    \      2. join()
 *                         3.获得同步锁   /                      \     3. 等待同步锁
 *                         4.notify()  /       获取CPU执行权      \    4. wait()
 *                    调用start()      ↓     -------------->      \
 *          _新建   ----------------> _就绪                       _运行   ---------------->  _死亡
 *                                          <--------------
 *                                        失去CPU执行权或yield()          执行完run();调用线程的stop();
 *
 *                                                                      出现Error / Exception 且没处理
 *
 *      售票问题: 三个进程同时阻塞时,第一个进程执行完余票为:1
 *              第二个进程执行时,此时--操作余票为:0
 *              第三个进程执行时,此时--操作余票为:-1
 *
 *     解决问题:
 *          方式一: 同步代码块
 *          synchronize(同步监视器){
 *              //需要被同步的代码
 *          }
 *          说明:操作共享数据的代码,即为需要被同步的代码
 *          共享数据:多个线程共同操作的变量.比如:ticket就是共享数据
 *          同步监视器:锁.任何一个类的对象都可以充当锁
 *             要求: 多个线程必须要[共用同一把锁]
 *
 *          方式二: 同步方法
 *
 *
 *     同步的方式,解决了线程的安全问题. ------>  优势
 *     操作同步代码时,只能有一个线程参与,其他线程等待.相当于是一个单线程的过程,效率低  -------> 劣势
 *
 *     关于同步方法的总结:
 *     1. 同步方法仍然涉及到同步监视器,只是不需要我们显式的声明
 *     2. 非静态的同步方法,同步监视器是:this
 *        静态的同步方法,同步监视器是: 当前类本身
 *
 *
 * */
public class ThreadLife {
    public static void main(String[] args) {
//       ThreadRunnable();
//        ThreadRunnableSynchronized();  实现Runnbale接口, 添加Synchronized方法

        Window4 win1 = new Window4();
        Window4 win2 = new Window4();
        Window4 win3 = new Window4();

        win1.start();
        win2.start();
        win3.start();
    }


    //实现Runnbale接口, 添加Synchronized方法
    private static void ThreadRunnableSynchronized() {
        Window3 window3 = new Window3();
        Thread t1 = new Thread(window3);
        Thread t2 = new Thread(window3);
        Thread t3 = new Thread(window3);

        t1.start();
        t2.start();
        t3.start();
    }

    private static void ThreadRunnable() {
        Window window = new Window();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable{

    private int ticket = 100;

    private Object object = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (object) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票,票号为: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

class Window2 extends Thread{

    private static int ticket = 100;

    private static Object object = new Object();

    @Override
    public void run() {
        while (true) {
 //           synchronized (object) {
            synchronized (this) {   //调用的是window2对象 window2对象是唯一的
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票,票号为: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

class Window3 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            Show();
        }
    }

    private synchronized void Show() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票,票号为: " + ticket);
            ticket--;
        }
    }
}

class Window4 extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        while (true){
            Show();
        }
    }

    private static synchronized void Show() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票,票号为: " + ticket);
            ticket--;
        }
    }
}