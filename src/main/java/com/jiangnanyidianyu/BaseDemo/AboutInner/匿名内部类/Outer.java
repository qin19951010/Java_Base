package com.jiangnanyidianyu.BaseDemo.AboutInner.匿名内部类;

/**
 * @ClassName Outer
 * @Author: Qinnn、
 * @Description: TODO 匿名内部类
 * @Date: create in 2020/10/14 11:10
 */

public class Outer {

    public static IAnimal getInnerInstance(final String speak){
        return new IAnimal(){
            @Override
            public void speak(){
                System.out.println(speak);
            }};
        //注意上一行的分号必须有
    }

    public static void main(String[] args){
        //调用的speak()是重写后的speak方法。
        Outer.getInnerInstance("小狗汪汪汪！").speak();
    }
}
