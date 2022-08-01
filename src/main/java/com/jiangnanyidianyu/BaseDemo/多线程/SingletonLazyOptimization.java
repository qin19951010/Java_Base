package com.jiangnanyidianyu.BaseDemo.多线程;

/**
 * @ClassName SingletonLazy
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 11:29
 */
public class SingletonLazyOptimization {

    /*
    * 优点:
    *   懒加载
    *   易实现
    *   线程安全
    *
    * 缺点:
    *   效率低(synchronized 同步加锁影响效率)
    * */

    private static SingletonLazyOptimization instance;

    private SingletonLazyOptimization(){}

    //同步加锁影响效率
    public static SingletonLazyOptimization getInstance()
    {
        //1. 效率较低
        synchronized (SingletonLazyOptimization.class){
            if(instance == null){
                instance = new SingletonLazyOptimization();
            }
        }

        //2. 优化,防止锁被其中一个线程占用时,其他线程还在等待  ----> 双重等待
        if(instance == null){
            synchronized (SingletonLazyOptimization.class){
                if(instance == null){
                    instance = new SingletonLazyOptimization();
                }
            }
        }

        return instance;
    }

}
