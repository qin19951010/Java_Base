package com.jiangnanyidianyu.BaseDemo.设计模式.建造者模式.普通实现;

import org.junit.Test;

/**
 * @ClassName CommonHouse
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 13:46
 */
public class CommonHouse extends AbstractHouse{
    /*
    *   传统模式造房子需求
    *   优点:
    *       1.简单易实现
    *   缺点:
    *       设计的程序结构，过于简单，没有设计缓存层对象，程序的扩展和维护不好，也就是说，
    * 这种设计方案，耦合度增强了.
    * */
    @Override
    public void buildBasic() {
        System.out.println("打地基。。。。");
    }

    @Override
    public void buildWalls() {
        System.out.println("砌墙。。。。");
    }

    @Override
    public void roofed() {
        System.out.println("封顶。。。。");
    }

    @Test
    public void test()
    {
        CommonHouse commonHouse = new CommonHouse();
        commonHouse.build();
    }

}
