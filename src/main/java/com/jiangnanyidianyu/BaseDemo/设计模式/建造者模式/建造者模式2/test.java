package com.jiangnanyidianyu.BaseDemo.设计模式.建造者模式.建造者模式2;

import org.junit.Test;

/**
 * @ClassName test
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 14:43
 */
public class test {
    @Test
    public void test()
    {
        Phone phone = new Phone.Builder()
                .setBrand("iphone")
                .setMemory(8)
                .setStorage(32)
                .setColor("white")
                .setSize(9)
                .build();
        System.out.println(phone);
    }
}
