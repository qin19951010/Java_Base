package com.jiangnanyidianyu.BaseDemo.设计模式.简单工厂模式;

/**
 * @ClassName IPhone
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 10:34
 */
public class IPhone implements Phone{

    public IPhone() {
        this.make();
    }

    @Override
    public void make() {
        System.out.println("生产苹果手机~");
    }
}
