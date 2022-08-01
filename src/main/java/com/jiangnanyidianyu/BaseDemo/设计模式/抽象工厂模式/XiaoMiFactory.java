package com.jiangnanyidianyu.BaseDemo.设计模式.抽象工厂模式;

import com.jiangnanyidianyu.BaseDemo.设计模式.简单工厂模式.MiPhone;
import com.jiangnanyidianyu.BaseDemo.设计模式.简单工厂模式.Phone;

/**
 * @ClassName XiaoMiFactory
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/15 11:14
 */
public class XiaoMiFactory implements AbstractFactory{
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }

    @Override
    public PC makePC() {
        return new MiPC();
    }
}
