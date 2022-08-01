package com.jiangnanyidianyu.BaseDemo.设计模式.抽象工厂模式;

import com.jiangnanyidianyu.BaseDemo.设计模式.简单工厂模式.Phone;

public interface AbstractFactory {
    Phone makePhone();
    PC makePC();
}
