package com.jiangnanyidianyu.BaseDemo.设计模式.JDK动态代理.JDK动态代理2;

/**
 * @ClassName DataChangeImp
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/13 15:11
 */
public class DataChangeImp implements DataChange{
    @Override
    public String change(String msg) {
        System.out.println("数据改变,包含[" + msg + "]");
        return msg;
    }

    public String insert(String msg) {
        System.out.println("插入数据,包含[" + msg + "]");
        return msg;
    }
}
