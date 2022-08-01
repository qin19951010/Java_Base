package com.jiangnanyidianyu.BaseDemo.AboutReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName Apple
 * @Author: Qinnn、
 * @Description: TODO Apple类
 * @Date: create in 2020/10/10 14:19
 */
public class Apple {

    private int price;

    public String name;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) throws Exception{

        //1.正常的调用
        Apple apple = new Apple();
        apple.setPrice(5);
        System.out.println("Apple Price:" + apple.getPrice());

        /**
        *   反射获取对象并调用方法
        *   1.通过Class.forName("com.jiangnanyidianyu.BaseDemo.AboutReflection.Apple")获得Class对象
         *  2.clz.getConstructor获取类的无参构造方法
         *  3.clz.getMethod(方法名,参数)获取成员方法
         *  4.Constructor.newInstance()实例化对象
         *  5.Method.invoke(实例化对象, 方法参数);
        */
        //2.使用反射调用
        Class clz = Class.forName("com.jiangnanyidianyu.BaseDemo.AboutReflection.Apple");
        Method setPriceMethod = clz.getMethod("setPrice", int.class);
        Constructor appleConstructor = clz.getConstructor();
        Object appleObj = appleConstructor.newInstance();

        setPriceMethod.invoke(appleObj, 14);
        Method getPriceMethod = clz.getMethod("getPrice");
        System.out.println("Apple Price:" + getPriceMethod.invoke(appleObj));

        /**
        *   获取反射中的class对象的三种方式
         *  1.使用 Class.forName 静态方法,根据全类名获取
         *  2.使用 .class 方法
         *  3.使用类对象的 getClass() 方法。
        */
        Class clzStr1 = Class.forName("java.lang.String");
        Class clzStr2 = String.class;
        String Str = new String("Reflection");
        Class clzStr4 = Str.getClass();

        /**
        *   通过反射创建类对象
        *   1.通过 Class 对象的 newInstance() 方法。
        *   2.通过 Constructor 对象的 newInstance() 方法
         *
         *   通过 Constructor 对象创建类对象可以选择特定构造方法，
         *   而通过 Class 对象则只能使用默认的无参数构造方法
         *
        */
        Class clzApple = Apple.class;
        Apple apple2 = (Apple)clzApple.newInstance();

        Constructor constructor = clzApple.getConstructor();
        Apple objApple = (Apple)constructor.newInstance();

        /**
         *   通过反射获取类属性、方法、构造器
         *   1.通过 Class 对象的 getFields() 方法可以获取 Class 类的属性，但无法获取私有属性
         *   2.通过getDeclaredFields() 方法则可以获取包括私有属性在内的所有属性
         *
         *   与获取类属性一样，当我们去获取类方法、类构造器时
         *   如果要获取私有方法或私有构造器，则必须使用有 declared 关键字的方法。
         */
        Field[] fields = clzApple.getFields();
        for (Field field:fields) {
            System.out.println("getFields():" + field.getName());
        }

        Field[] fields2 = clzApple.getDeclaredFields();
        for (Field field:fields2) {
            System.out.println("getDeclaredFields():" + field.getName());
        }
    }
}
