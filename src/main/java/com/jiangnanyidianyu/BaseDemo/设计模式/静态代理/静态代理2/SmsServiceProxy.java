package com.jiangnanyidianyu.BaseDemo.设计模式.静态代理.静态代理2;

/**
 * @ClassName SmsServiceProxy
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/13 10:08
 */
public class SmsServiceProxy implements SmsService{

    //代理对象
    private final SmsService smsService;

    //代理类中注入目标对象
    public SmsServiceProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        before();
        System.out.println(message);
        after();
        return message;
    }
    public void before(){
        System.out.println("发送消息前~");
    }
    public void after(){
        System.out.println("发送消息后~");
    }

    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsServiceProxy smsServiceProxy = new SmsServiceProxy(smsService);
        smsServiceProxy.send("静态代理");
    }
}
