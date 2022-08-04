package com.jiangnanyidianyu.BaseDemo.设计模式.策略工厂;

import java.util.HashMap;
import java.util.Map;

/**
 * @author QinZhongliang
 * @date 2022年08月03日 4:49 PM
 */
public class PayStrategyFactory {
    private static Map<String, IPay> PAY_REGISTERS = new HashMap<>();

    public static void register(String code, IPay iPay) {
        if (null != code && !"".equals(code)) {
            PAY_REGISTERS.put(code, iPay);
        }
    }

    public static IPay get(String code) {
        return PAY_REGISTERS.get(code);
    }
}
