package com.jiangnanyidianyu.多线程.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一个线程输出a，一个线程输出b，一个线程输出c，abc按照顺序输出，连续输出5次
 *
 * @author QinZhongliang
 * @date 2022年08月02日 1:52 PM
 */
public class ReentrantLockDemo2 {
    public static void main(String[] args) {
        AwaitSignal awaitSignal = new AwaitSignal(5);
        // 构建三个条件变量
        Condition a = awaitSignal.newCondition();
        Condition b = awaitSignal.newCondition();
        Condition c = awaitSignal.newCondition();
        // 开启三个线程
        new Thread(() -> {
            awaitSignal.print("a", a, b);
        }).start();

        new Thread(() -> {
            awaitSignal.print("b", b, c);
        }).start();

        new Thread(() -> {
            awaitSignal.print("c", c, a);
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        awaitSignal.lock();
        try {
            // 先唤醒a
            a.signal();
        } finally {
            awaitSignal.unlock();
        }
    }
}


class AwaitSignal extends ReentrantLock {

    // 循环次数
    private int loopNumber;

    public AwaitSignal(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    /**
     * @param print   输出的字符
     * @param current 当前条件变量
     * @param next    下一个条件变量
     */
    public void print(String print, Condition current, Condition next) {

        for (int i = 0; i < loopNumber; i++) {
            lock();
            try {
                try {
                    // 获取锁之后等待
                    current.await();
                    System.out.print(print);
                } catch (InterruptedException e) {
                }
                next.signal();
            } finally {
                unlock();
            }
        }
    }
}
