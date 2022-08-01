package com.jiangnanyidianyu.BaseDemo.设计模式.建造者模式.建造者模式1;

/**
 * @ClassName HouseBuilder
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 13:57
 */
public abstract class HouseBuilder {
    /*
    *   抽象类:HouseBuilder
    *
    * */
    protected House house = new House();

    //打地基
    public abstract void buildBasic();

    //砌墙
    public abstract void buildWalls();

    //封顶
    public abstract void roofed();

    //建造房子
    public House buildHouse() {
        return house;
    }
}
