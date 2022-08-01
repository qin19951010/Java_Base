package com.jiangnanyidianyu.BaseDemo.设计模式.抽象工厂模式;

/**
 * @ClassName MAC
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 11:06
 */
public class MAC implements PC{

    public MAC() {
        this.make();
    }

    @Override
    public void make() {
        System.out.println("make MAC!");
    }
}
