package com.jiangnanyidianyu.BaseDemo.设计模式.JDK动态代理.JDK动态代理2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName DataInvocationHandler
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/13 15:16
 */
public class DataInvocationHandler implements InvocationHandler {

    private final Object target;

    public DataInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //开启事务
        OpenTransaction();
        Object obj = method.invoke(target, args);
        //提交事务
        CommitTransaction();
        return obj;
    }

    private void OpenTransaction()
    {
        System.out.println("开启事务!");
    }

    private void CommitTransaction()
    {
        System.out.println("提交事务!");
    }
}
