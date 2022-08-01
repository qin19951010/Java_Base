package com.jiangnanyidianyu.BaseDemo.设计模式.工厂方法模式;

import com.jiangnanyidianyu.BaseDemo.设计模式.简单工厂模式.IPhone;
import com.jiangnanyidianyu.BaseDemo.设计模式.简单工厂模式.Phone;

/**
 * @ClassName IphoneFactory
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 10:54
 */
public class IphoneFactory implements AbstractFactory{
    @Override
    public Phone makePhone() {
        return new IPhone();
    }
}
