package com.jiangnanyidianyu.BaseDemo.设计模式.CGLIB动态代理;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName AliMessageMethodInterceptor
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/13 14:16
 */
public class AliMessageMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method " + method.getName());
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after method " + method.getName());
        return object;
    }
}
