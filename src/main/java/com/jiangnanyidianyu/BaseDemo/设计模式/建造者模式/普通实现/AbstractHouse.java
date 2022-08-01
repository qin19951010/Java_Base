package com.jiangnanyidianyu.BaseDemo.设计模式.建造者模式.普通实现;

/**
 * @ClassName AbstractHouse
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 13:45
 */
public abstract class AbstractHouse {
    //打地基
    public abstract void buildBasic();

    //砌墙
    public abstract void buildWalls();

    //封顶
    public abstract void roofed();

    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }
}
