package com.jiangnanyidianyu.BaseDemo.设计模式.单例模式;

/**
 * @ClassName Singleton
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 11:25
 */
public class Singleton {
    /*
    * 优点:
    *   懒加载,易实现
    * 缺点:
    *   线程不安全（不支持多线程，多个线程同时访问 getInstance() 方法时，
    * 会有可能创建多个实例，所以严格意义上不是单例模式）
    **/

    private static Singleton instance;

    public Singleton() {
    }

    public static Singleton getInstance()
    {
        if (instance ==  null)
        {
            instance = new Singleton();
        }
        return instance;
    }
}
