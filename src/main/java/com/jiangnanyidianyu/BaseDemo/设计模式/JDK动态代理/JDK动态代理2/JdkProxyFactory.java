package com.jiangnanyidianyu.BaseDemo.设计模式.JDK动态代理.JDK动态代理2;

import java.lang.reflect.Proxy;

/**
 * @ClassName JdkProxyFactory
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/13 15:15
 */
public class JdkProxyFactory {

    public static Object getProxy(Object target)
    {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DataInvocationHandler(target));
    }
}
