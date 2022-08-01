package com.jiangnanyidianyu.BaseDemo.设计模式.静态代理.静态代理2;

/**
 * @ClassName SmsServiceImpl
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/13 10:07
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message: " + message);
        return message;
    }
}
