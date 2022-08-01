package com.jiangnanyidianyu.BaseDemo.设计模式.简单工厂模式;

import org.junit.Test;

/**
 * @ClassName phoneFactory
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 10:35
 */
public class phoneFactory{
    public static Phone makePhone(String phoneType){
        Phone phone = null;
        switch (phoneType){
            case "小米":
                phone = new MiPhone();
                break;
            case "苹果":
                phone = new IPhone();
                    break;
        }
        return phone;
    }

    @Test
    public void test()
    {
        Phone phone = phoneFactory.makePhone("小米");
        Phone phone1 = phoneFactory.makePhone("苹果");
    }
}
