package com.jiangnanyidianyu.BaseDemo.设计模式.策略工厂;

/**
 * @author QinZhongliang
 * @date 2022年08月03日 4:50 PM
 */
public class PayService3 {
    public void toPay(String code) {
        PayStrategyFactory.get(code).pay();
    }
}
