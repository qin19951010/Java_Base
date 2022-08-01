package com.jiangnanyidianyu.BaseDemo.设计模式.抽象工厂模式;

import com.jiangnanyidianyu.BaseDemo.设计模式.简单工厂模式.IPhone;
import com.jiangnanyidianyu.BaseDemo.设计模式.简单工厂模式.Phone;

/**
 * @ClassName AppleFactory
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 11:15
 */
public class AppleFactory implements AbstractFactory{
    @Override
    public Phone makePhone() {
        return new IPhone();
    }

    @Override
    public PC makePC() {
        return new MAC();
    }
}
