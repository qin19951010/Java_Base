package com.jiangnanyidianyu.BaseDemo.设计模式.JDK动态代理.JDK动态代理2;

/**
 * @ClassName test
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/13 15:25
 */
public class test {
    public static void main(String[] args) {
        DataChange target = (DataChange)JdkProxyFactory.getProxy(new DataChangeImp());
        target.change("通过jdk动态代理新增事务开启提交功能");
    }
}
