package com.jiangnanyidianyu.多线程.ThreadPool.跨类传递数据;

/**
 * @author QinZhongliang
 * @date 2022年08月04日 10:52 AM
 */
public class RepertorySystem {
    /**
     * 减库存方法
     */
    public void decrement() {
        // 得到用户信息
        User user = UserStorage.USER.get();
        // 业务处理代码（忽略）...
        System.out.println(String.format("仓储系统收到用户：%s 的请求。",
                user.getName()));
    }
}
