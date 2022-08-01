package com.jiangnanyidianyu.BaseDemo.多线程;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/7/3 17:37
 **/
/**
 * 创建多线程的方式二: 实现Runnable接口
 *  1.创建一个实现了Runnable接口的类
 *  2.实现类去实现Runnable中的抽象方法:run()
 *  3.创建实现类的对象
 *  4.将此对象作为参数传递到Thread类的构造器中,创建Thread类的对象
 *  5.通过Thread类的对象调用start()
 *
 *  比较创建线程的两种方法.
 *    开发中:优先选择实现Runnable接口的方式
 *    原因:1.实现的方式没有类的单继承性的局限性
 *        2.实现的方式更适合来处理多个线程有共享数据的情况
 *
 *    联系:Thread类本身也实现Runnable
 *    相同点:两种方式都需要重写run(),将线程要执行的逻辑声明在run()中
 *
 *
 * */

class MThread implements Runnable{
    //2.实现类去实现Runnable中的抽象方法:run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class Thread_02 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        MThread mThread = new MThread();
        //4.将此对象作为参数传递到Thread类的构造器,创建Thread类的对象
        Thread t1 = new Thread(mThread);
        //5.通过Thread类的对象调用start():①启动线程 ②调用当前线程的run()--->调用了Runnable类型的target方法
        t1.start();
    }

}
