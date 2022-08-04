package com.jiangnanyidianyu.多线程.ThreadPool.跨类传递数据;

/**
 * 订单类
 * @author QinZhongliang
 * @date 2022年08月04日 10:51 AM
 */
public class OrderSystem {
    /**
     * 订单添加方法
     */
    public void add() {
        // 得到用户信息
        User user = UserStorage.USER.get();
        // 业务处理代码（忽略）...
        System.out.println(String.format("订单系统收到用户：%s 的请求。",
                user.getName()));
    }
}
