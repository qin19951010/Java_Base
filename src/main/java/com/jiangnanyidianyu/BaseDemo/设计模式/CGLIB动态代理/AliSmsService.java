package com.jiangnanyidianyu.BaseDemo.设计模式.CGLIB动态代理;

/**
 * @ClassName AliSmsService
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/13 14:16
 */
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message " + message);
        return message;
    }
}
