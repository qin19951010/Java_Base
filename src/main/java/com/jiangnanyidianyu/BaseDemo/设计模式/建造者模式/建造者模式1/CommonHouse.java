package com.jiangnanyidianyu.BaseDemo.设计模式.建造者模式.建造者模式1;

/**
 * @ClassName CommonHouse
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 13:59
 */
public class CommonHouse extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("打地基5m。。。。");
    }

    @Override
    public void buildWalls() {
        System.out.println("砌墙5m。。。。");
    }

    @Override
    public void roofed() {
        System.out.println("封顶5m。。。。");
    }
}
