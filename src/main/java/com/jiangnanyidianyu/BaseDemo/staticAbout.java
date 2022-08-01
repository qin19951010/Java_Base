package com.jiangnanyidianyu.BaseDemo;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/6/28 10:10
 **/
public class staticAbout {
    /*
    *   比如通过 Class.forName("ClassDemo")创建 Class 对象的时候也会执行，
    *   即 new 或者 Class.forName("ClassDemo") 都会执行静态代码块。
    *
    *
    *   一般情况下,如果有些代码比如一些项目最常用的变量或对象必须在项目启动的时候就执行的时候,需要使用静态代码块,这种代码是主动执行的。
    *   如果我们想要设计不需要创建对象就可以调用类中的方法，例如：Arrays 类，Character 类，String 类等，就需要使用静态方法,
    *   两者的区别是 静态代码块是自动执行的而静态方法是被调用的时候才执行的.
    * */
}
class Test {
    public Test() {
        System.out.print("默认构造方法！--");
    }

    //非静态代码块
    {
        System.out.print("非静态代码块！--");
    }

    //静态代码块
    static {
        System.out.print("静态代码块！--");
    }

    private static void test() {
        System.out.print("静态方法中的内容! --");
        {
            System.out.print("静态方法中的代码块！--");
        }

    }

    public static void main(String[] args) {
        Test test = new Test();
        Test.test();//静态代码块！--静态方法中的内容! --静态方法中的代码块！--

        Test test2 = new Test();
    }
}