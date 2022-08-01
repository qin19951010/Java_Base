package com.jiangnanyidianyu.BaseDemo.设计模式.抽象工厂模式;

/**
 * @ClassName MiPC
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 11:05
 */
public class MiPC implements PC{
    public MiPC() {
        this.make();
    }

    @Override
    public void make() {
        System.out.println("make xiaomi PC!");
    }
}
