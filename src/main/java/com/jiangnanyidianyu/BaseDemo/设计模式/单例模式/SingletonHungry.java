package com.jiangnanyidianyu.BaseDemo.设计模式.单例模式;

/**
 * @ClassName SingleHungry
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 11:33
 */
public class SingletonHungry {
    /*
    *   [饿汉式]
    *
    *   优点:
    *       1.线程安全 2.没有加锁,效率高 3.易实现
    *   缺点:
    *       1.非懒加载方式 2.类加载时就初始化,浪费内存(基于classloader机制)
    * */
    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {}

    public static SingletonHungry getInstance(){
        return instance;
    }
}
