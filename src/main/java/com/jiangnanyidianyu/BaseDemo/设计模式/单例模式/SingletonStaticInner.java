package com.jiangnanyidianyu.BaseDemo.设计模式.单例模式;

/**
 * @ClassName SingletonStaticInner
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 11:42
 */
public class SingletonStaticInner {
    /*
    *   静态内部类
    *   优点:
    *       1.懒加载 2.线程安全 3.操作难度一般
    *   和饿汉式一样利用了classloader机制,不同的是调用的时候才加载,可以延迟加载
    *
    * */
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private SingletonStaticInner() {}

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
