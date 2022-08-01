package com.jiangnanyidianyu.BaseDemo.设计模式.单例模式;

/**
 * @ClassName SingletonLazy
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 11:29
 */
public class SingletonLazy {

    /*
    * 优点:
    *   懒加载
    *   易实现
    *   线程安全
    *
    * 缺点:
    *   效率低(synchronized 同步加锁影响效率)
    * */

    private static SingletonLazy instance;

    private SingletonLazy(){}

    //同步加锁影响效率
    public static synchronized SingletonLazy getInstance()
    {
        if(instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }

}
