package com.jiangnanyidianyu.BaseDemo.设计模式.静态代理;

/**
 * @ClassName Test
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2020/10/9 11:32
 */
public class Test {

    public static void main(String[] args) {

        // ⽬标对象
        You you = new You();

        // 构造代理⻆⾊同时传⼊真实⻆⾊
        MarryCompanyProxy marryCompanyProxy = new MarryCompanyProxy(you);

        // 通过代理对象调⽤⽬标对象中的⽅法
        marryCompanyProxy.toMarry();
    }

}
