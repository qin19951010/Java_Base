package com.jiangnanyidianyu.BaseDemo.设计模式.策略工厂;

import javax.annotation.PostConstruct;

/**
 * @author QinZhongliang
 * @date 2022年08月03日 4:50 PM
 */
public class JingDongPay implements IPay{
    @PostConstruct
    public void init() {
        PayStrategyFactory.register("jingDongPay", this);
    }

    @Override
    public void pay() {
        System.out.println("===发起京东支付===");
    }
}
