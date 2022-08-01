package com.jiangnanyidianyu.BaseDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/6/28 10:17
 **/
public class DebugInvocationHandler implements InvocationHandler {
    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method " + method.getName());
        return result;
    }
}

class test implements Iadd{
    public Integer add(int a,int b){
        return a+b;
    }

    public static void main(String[] args) {
        DebugInvocationHandler handler = new DebugInvocationHandler(new test());
//        Object o = handler.invoke();
    }
}

interface Iadd{
    public Integer add(int a,int b);
}
