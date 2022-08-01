package com.jiangnanyidianyu.BaseDemo.Lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/6/29 22:34
 **/

/**
 *  如果一个接口中,只声明了一个抽象方法,则此接口就称为函数式接口
 *
 *
 * */
public class LambdaTest1 {
    @Test
    public void test01(){
        Runnable r1 = new Runnable(){

            @Override
            public void run() {
                System.out.println("我爱北京天安门~");
            }
        };
        r1.run();
        System.out.println("==========================");

        Runnable r2 = () -> System.out.println("我爱北京故宫~");
        r2.run();
    }

    @Test
    public void test02(){
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("TTTTTT");

        System.out.println("===========================");

        //类型推断
        Consumer<String> consumer2 = (s) -> System.out.println(s);
        consumer2.accept("SSSSSSSSSSS");
    }

    @Test
    public void test03(){
        //Lambda 需要两个或以上的参数,多条执行语句,并且可以有返回值

        Comparator<Integer> comparable = new Comparator<Integer>(){
            @Override
            public int compare(Integer n1,Integer n2) {
                System.out.println(n1);
                System.out.println(n2);
                return n1.compareTo(n2);
            }
        };

        System.out.println("=====================================");

        Comparator<Integer> comparable2 = (n1,n2) -> {
            System.out.println(n1);
            System.out.println(n2);
            return n1.compareTo(n2);
        };

        int i = comparable2.compare(2, 3);
        System.out.println(i);
    }

    @Test
    public void test04(){
        //当Lambda只有一条语句时,return与大括号若有,都可以省略
        Comparator<Integer> comparable2 = (n1,n2) -> n1.compareTo(n2);
        System.out.println(comparable2.compare(1, 1));

    }
}
