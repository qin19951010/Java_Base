package com.jiangnanyidianyu.多线程.ThreadPool.跨类传递数据;

/**
 * @author QinZhongliang
 * @date 2022年08月04日 10:50 AM
 */
/**
 * 用户实体类
 */
public class User {
    public User(String name) {
        this.name = name;
    }
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
