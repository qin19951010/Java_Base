package com.jiangnanyidianyu.BaseDemo.设计模式.JDK动态代理;

import com.jiangnanyidianyu.BaseDemo.设计模式.静态代理.静态代理2.SmsService;
import com.jiangnanyidianyu.BaseDemo.设计模式.静态代理.静态代理2.SmsServiceImpl;

/**
 * @ClassName test
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/13 15:07
 */
public class test {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("jdk动态代理");
    }
}
