package com.jiangnanyidianyu.BaseDemo.设计模式.建造者模式.建造者模式1;

/**
 * @ClassName HouseDirector
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 14:02
 */
public class HouseDirector {
    HouseBuilder houseBuilder = null;

    //构造器传入
    public HouseDirector(HouseBuilder houseBuilder){
        this.houseBuilder = houseBuilder;
    }

    //setter传入
    public void setHouseBuilder(HouseBuilder houseBuilder){
        this.houseBuilder = houseBuilder;
    }

    //如何处理建造房子流程，交给指挥者
    public House constructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}
