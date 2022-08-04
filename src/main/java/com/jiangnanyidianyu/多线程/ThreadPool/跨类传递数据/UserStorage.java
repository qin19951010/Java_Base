package com.jiangnanyidianyu.多线程.ThreadPool.跨类传递数据;

/**
 * @author QinZhongliang
 * @date 2022年08月04日 10:51 AM
 */
/**
 * 用户信息存储类
 */
public class UserStorage {
    // 用户信息
    public static ThreadLocal<User> USER = new ThreadLocal();

    /**
     * 存储用户信息
     * @param user 用户数据
     */
    public static void setUser(User user) {
        USER.set(user);
    }
}
