package com.jiangnanyidianyu.BaseDemo.设计模式.静态代理;

/**
 * @ClassName MarryCompanyProxy
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2020/10/9 11:27
 */

/**
 * 静态代理 ——> 代理对象
 * 婚期公司代理结婚,增强功能
 */
public class MarryCompanyProxy implements Marry {

    // ⽬标对象
    private Marry marry;

    // 通过构造器将⽬标对象传⼊
    public MarryCompanyProxy(Marry marry) {
        this.marry = marry;
    }

    // 实现⾏为
    @Override
    public void toMarry() {

        // 增强⾏为
        before();

        // 执⾏⽬标对象中的⽅法
        marry.toMarry();

        // 增强⾏为
        after();
    }

    /**
     * 增强行为
     */
    private void after() {
        System.out.println("新婚快乐，早⽣贵⼦！");
    }

    /**
     * 增强行为
     */
    private void before() {
        System.out.println("场地正在布置中...");
    }
}
