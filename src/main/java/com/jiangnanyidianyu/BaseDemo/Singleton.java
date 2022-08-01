package com.jiangnanyidianyu.BaseDemo;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/6/28 10:05
 **/
public class Singleton {

    //1.声明为private避免调用默认的构造方法创建对象
    private Singleton(){

    }
    //2.声明为private表明静态内部该类只能在该Singleton类中访问
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    //这种方式不仅具有延迟初始化的好处，而且由 JVM 提供了对线程安全的支持。
    public static Singleton getUniqueInstance(){
        return SingletonHolder.INSTANCE;
    }
}
