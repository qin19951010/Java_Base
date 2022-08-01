package com.jiangnanyidianyu.BaseDemo.设计模式.CGLIB动态代理;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibProxyFactory
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/13 14:08
 */
public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before method " + method.getName());
                Object object = methodProxy.invokeSuper(o, objects);
                System.out.println("after method " + method.getName());
                return object;
            }
        });
        // 创建代理类
        return enhancer.create();
    }
}
