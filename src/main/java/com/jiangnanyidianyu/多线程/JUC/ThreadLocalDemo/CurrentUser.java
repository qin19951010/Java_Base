package com.jiangnanyidianyu.多线程.JUC.ThreadLocalDemo;

import cn.hutool.system.UserInfo;

/**
 * @author QinZhongliang
 * @date 2022年08月03日 10:02 AM
 */
public class CurrentUser {
    private static final ThreadLocal<UserInfo> THREA_LOCAL = new ThreadLocal();

    public static void set(UserInfo userInfo) {
        THREA_LOCAL.set(userInfo);
    }

    public static UserInfo get() {
        return THREA_LOCAL.get();
    }

    public static void remove() {
        THREA_LOCAL.remove();
    }
}
