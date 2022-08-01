package com.jiangnanyidianyu.BaseDemo.设计模式.简单工厂模式;

/**
 * @ClassName MiPhone
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 10:33
 */
public class MiPhone implements Phone{

    public MiPhone() {
        this.make();
    }

    @Override
    public void make() {
        System.out.println("生产小米手机~");
    }
}
