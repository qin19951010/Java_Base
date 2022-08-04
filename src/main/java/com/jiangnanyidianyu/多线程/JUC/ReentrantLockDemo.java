package com.jiangnanyidianyu.多线程.JUC;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static sun.misc.GThreadHelper.lock;
import static sun.misc.GThreadHelper.unlock;

/**
 * @author QinZhongliang
 * @date 2022年08月02日 1:41 PM
 */
@Slf4j
public class ReentrantLockDemo {
    private static final ReentrantLock LOCK = new ReentrantLock();

    private static void m() {
        LOCK.lock();
        try {
            log.info("begin");
            // 调用m1()
            m1();
        } finally {
            // 注意锁的释放
            LOCK.unlock();
        }
    }

    public static void m1() {
        LOCK.lock();
        try {
            log.info("m1");
            m2();
        } finally {
            // 注意锁的释放
            LOCK.unlock();
        }
    }

    public static void m2() {
        LOCK.lock();
        try {
            log.info("m1");
        } finally {
            // 注意锁的释放
            LOCK.unlock();
        }
    }
}
