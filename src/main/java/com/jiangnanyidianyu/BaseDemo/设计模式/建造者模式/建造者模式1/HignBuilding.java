package com.jiangnanyidianyu.BaseDemo.设计模式.建造者模式.建造者模式1;

/**
 * @ClassName HignBuilding
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 14:01
 */
public class HignBuilding extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("高楼地基100m");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼砌墙100m");
    }

    @Override
    public void roofed() {
        System.out.println("高楼封顶100m");
    }
}
