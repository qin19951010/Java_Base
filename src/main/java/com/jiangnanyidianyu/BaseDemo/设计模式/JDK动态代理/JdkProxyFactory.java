package com.jiangnanyidianyu.BaseDemo.设计模式.JDK动态代理;

import java.lang.reflect.Proxy;

/**
 * @ClassName JdkProxyFactory JDK动态代理只能代理实现了接口的类
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/13 10:59
 */
public class JdkProxyFactory {
    /*  target : 被代理类
        三大参数
        1.ClassLoader : 类加载器
        2.Class<?>[] :
        代理对象实现的接口，可以实现多个接口，这些接口中的所有方法都会按照invoke模板
        中的代码进行加强
        3.InvocationHandler :传入InvocationHandler接口的实现类,
        该类中的invoke方法是代理对象中所有方法的逻辑处理模板
     */
    public static Object getProxy(Object target) {
        //用于创建动态代理对象，该类也是所有生成的动态代理对象的父类。
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MessageInvocationHandler(target));
    }
}
