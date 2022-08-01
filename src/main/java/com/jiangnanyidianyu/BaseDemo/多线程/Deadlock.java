package com.jiangnanyidianyu.BaseDemo.多线程;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/7/4 14:32
 **/
/**
 *
 *  死锁:
 *    --> 不同的线程分别占用对方需要的同步资源不放弃,都在等待对方放弃自己需要的同步资源,就形成了线程的死锁
 *
 *    --> 出现死锁后,不会出现异常,不会出现提示,只是所有的线程都处于阻塞状态,无法继续
 *        我们使用同步时,要避免出现死锁.
 *
 *
 *  解决办法:
 *    --> 专门的算法、原则
 *    --> 尽量减少同步资源的定义
 *    --> 尽量避免嵌套同步
 *
 *
 * */
class A{
    public synchronized void foo(B b){   //A类的对象: a
        System.out.println("当前线程名: " + Thread.currentThread().getName() + " 进入了A实例的foo方法");
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名: " + Thread.currentThread().getName() + " 企图调用B实例的last方法");
        b.last();
    }

    public synchronized void last(){
        System.out.println("进入了A类的last方法内部");
    }
}

class B{
    public synchronized void bar(A a){
        System.out.println("当前线程名: " + Thread.currentThread().getName() + " 进入了B实例的bar方法");
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名: " + Thread.currentThread().getName() + " 企图调用A实例的last方法");
        a.last();
    }

    public synchronized void last(){
        System.out.println("进入了B类的last方法内部");
    }
}


public class Deadlock implements Runnable{

    A a = new A();
    B b = new B();

    public void init(){
        Thread.currentThread().setName("主线程");
        //调用a对象的foo方法
        a.foo(b);
        System.out.println("进入了主线程之后");
    }

    public void run(){
        Thread.currentThread().setName("副线程");
        //调用b对象的bar方法
        b.bar(a);
        System.out.println("进入了副线程之后");
    }

    public static void main(String[] args) {
        /**
         *   分线程
         * */
        Deadlock dl = new Deadlock();
        new Thread(dl).start();

        /**
         *  主线程
         * */
        dl.init();
    }
//    public static void main(String[] args) {
//        StringBuffer s1 = new StringBuffer();
//        StringBuffer s2 = new StringBuffer();
//
//        new Thread(() -> {
//            synchronized (s1){
//
//                s1.append("a");
//                s2.append("1");
//
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                synchronized (s2){
//                    s1.append("b");
//                    s2.append("2");
//
//                    System.out.println(s1);
//                    System.out.println(s2);
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (s2){
//
//                    s1.append("c");
//                    s2.append("3");
//
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    synchronized (s1){
//                        s1.append("d");
//                        s2.append("4");
//
//                        System.out.println(s1);
//                        System.out.println(s2);
//                    }
//                }
//            }
//        }).start();
//    }
}


