package com.jiangnanyidianyu.BaseDemo.关键字;

/**
 * @ClassName final_test
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/2/24 10:19
 */
public class final_test {

    final String Str = "AAAA";

    final int n = 99;

    final Object obj = new Object();

    void ChangeVal()
    {
        //final修饰的变量是常量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改
        //Str = "BBBB";
        //n = 100;

        //如果是引用类型的变量，则在对其初始化之后便不能让其指向另一个对象
        //obj = new Object();
    }

    //被final修饰的类不可被继承
    final class A{
        public void method1()
        {
            System.out.println("method_1!");
        }
    }

//    class B extends A{
//
//    }

    class B{
        public final void method1(){
            System.out.println("B类的方法method1");
        }
    }

    //被final修饰的方法不能被重写
    class b extends B{
//        @Override
//        public final void method1(){
//            System.out.println("B类的方法method1");
//        }
    }
}
