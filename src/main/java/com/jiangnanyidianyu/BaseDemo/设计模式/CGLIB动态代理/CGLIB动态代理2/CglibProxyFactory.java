package com.jiangnanyidianyu.BaseDemo.设计模式.CGLIB动态代理.CGLIB动态代理2;

import com.jiangnanyidianyu.BaseDemo.设计模式.JDK动态代理.JDK动态代理2.DataChangeImp;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibProxyFactory
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 9:38
 */
public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz)
    {
        //1.生成增强类
        Enhancer enhancer = new Enhancer();
        //2.增强类设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        /*
          3.设置被代理类:
            cglib动态代理的方法增强是继承父类的方式,
            jdk动态代理是实现接口的方式
         */
        enhancer.setSuperclass(clazz);
        //4.设置方法拦截器,对方法进行增强
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("事务开启:" + method.getName());
                Object o = methodProxy.invokeSuper(obj, args);
                System.out.println("事务提交:" + method.getName());
                return o;
            }
        });
        //创建代理类
        return enhancer.create();
    }

    public static void main(String[] args) {
        DataChangeImp dataChangeImp = (DataChangeImp) CglibProxyFactory.getProxy(DataChangeImp.class);
        dataChangeImp.change("修改数据~");
        dataChangeImp.insert("插入数据~");
    }
}
