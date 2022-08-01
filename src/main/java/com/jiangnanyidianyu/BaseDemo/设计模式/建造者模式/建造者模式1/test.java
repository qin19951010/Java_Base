package com.jiangnanyidianyu.BaseDemo.设计模式.建造者模式.建造者模式1;

import org.junit.Test;

/**
 * @ClassName test
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 14:06
 */
public class test {
    @Test
    public void test()
    {
        CommonHouse commonHouse = new CommonHouse();
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        House house = houseDirector.constructHouse();

        HignBuilding hignBuilding = new HignBuilding();
        HouseDirector houseDirector2 = new HouseDirector(hignBuilding);
        houseDirector2.constructHouse();
    }
}
