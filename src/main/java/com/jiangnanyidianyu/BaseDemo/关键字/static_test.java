package com.jiangnanyidianyu.BaseDemo.关键字;

/**
 * @ClassName static_test
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/2/24 11:10
 */
public class static_test {

}

class A{
    public A() {
        System.out.println("class A");
    }

    {
        System.out.println("I'm A class");
    }

    static {
        System.out.println("class A static");
    }
}

class B extends A{
    public B(){
        System.out.println("class B");
    }

    {
        System.out.println("I'm A class");
    }

    static { System.out.println("class B static"); }

    public static void main(String[] args) {
        new B();
    }

    /*
        class A static
        class B static
        I'm A class
        class A
        I'm A class
        class B
    * */
}
