package com.jiangnanyidianyu.BaseDemo.Lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.function.Consumer;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/6/29 23:02
 **/
/*
*   1.使用情景:当要传递给Lambda体的操作,已经有实现的方法了,可以使用方法引用!
*
*   2.方法引用,本质上就是lambda表达式,而Lambda表达式作为函数式接口的实例.
*      所以,方法引用也是函数式接口的实例
*
*   3.使用格式: 类(或对象) :: 方法名
*
*   4.具体分为如下三种情况
*       对象::非静态方法
*       类::静态方法
*       类::非静态方法
* */
public class MethodTest {

    @Test
    public void test1(){
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("Qinnn");
    
        System.out.println("====================");
        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("beijing");
    }

}
