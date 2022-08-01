package com.jiangnanyidianyu.BaseDemo.设计模式.静态代理;

/**
 * @ClassName You
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2020/10/9 11:26
 */

/**
 * 静态代理 ——> ⽬标对象
 */
public class You implements Marry {
    // 实现⾏为
    @Override
    public void toMarry() {
        System.out.println("我要结婚了...");
    }
}
