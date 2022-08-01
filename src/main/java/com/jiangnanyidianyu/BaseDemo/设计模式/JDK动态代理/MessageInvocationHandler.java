package com.jiangnanyidianyu.BaseDemo.设计模式.JDK动态代理;

import java.lang.reflect.Method;

/**
 * @ClassName MessageInvocationHandler
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/13 10:50
 */
//动态代理由程序在内存中动态生成一个对象，
// 不需要我们手写代理对象，
// 我们只需要指定代理方法的模板即可。
public class MessageInvocationHandler implements java.lang.reflect.InvocationHandler {

    private final Object target;

    public MessageInvocationHandler(Object target) {
        this.target = target;
    }

    /*
        InvocationHandler接口中的invoke就是代理方法的模板
        三个参数:
        1.Object proxy: 代表代理对象本身，通过它调用代理对象的其他方法
        2.Method method: 代表`被代理对象`对应方法的字节码对象
        3.Object[] args: 传入`代理对象`对应方法的参数数组
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method" + method.getName());
        return result;
    }
}
