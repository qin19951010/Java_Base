package com.jiangnanyidianyu.BaseDemo.设计模式.策略工厂;

import javax.annotation.PostConstruct;

/**
 * @author QinZhongliang
 * @date 2022年08月03日 4:50 PM
 */
public class WeixinPay implements IPay{
    @PostConstruct
    public void init() {
        PayStrategyFactory.register("weixinPay", this);
    }

    @Override
    public void pay() {
        System.out.println("===发起微信支付===");
    }
}
