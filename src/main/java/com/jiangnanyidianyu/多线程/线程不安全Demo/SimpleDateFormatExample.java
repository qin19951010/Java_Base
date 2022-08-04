package com.jiangnanyidianyu.多线程.线程不安全Demo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1. 将 SimpleDateFormat 定义为局部变量；
 * 2. 使用 synchronized 加锁执行；
 * 3. 使用 Lock 加锁执行(和解决方案 2 类似)；
 * 4. 使用 ThreadLocal；
 * 5. 使用 JDK 8 中提供的 DateTimeFormat
 *
 * @author QinZhongliang
 * @date 2022年08月04日 9:21 AM
 */
public class SimpleDateFormatExample {
    // 创建 SimpleDateFormat 对象
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

    /** 
     *  线程不安全示例
     */
    public void test01(){
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // 执行 10 次时间格式化
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            // 线程池执行任务
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    // 创建时间对象
                    Date date = new Date(finalI * 1000);
                    // 执行时间格式化并打印结果
                    System.out.println(simpleDateFormat.format(date));
                }
            });
        }
    }

    /**
     *  synchronized解决线程不安全问题
     */
    @Test
    public void test02(){
        //  创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // 执行 10 次时间格式化
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            // 线程池执行任务
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    // 创建时间对象
                    Date date = new Date(finalI * 1000);
                    // 执行时间格式化并打印结果
                    synchronized (simpleDateFormat) {
                        System.out.println(simpleDateFormat.format(date));
                    }
                }
            });
        }
        //  关闭线程池
        threadPool.shutdown();
    }

    /**
     *  使用Lock手动加锁
     */
    @Test
    public void test03(){
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // 创建Lock锁
        Lock lock = new ReentrantLock();
        // 执行 10 次时间格式化
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            // 线程池执行任务
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    // 创建时间对象
                    Date date = new Date(finalI * 1000);
                    // 执行时间格式化并打印结果
                    lock.lock();
                    try{
                        System.out.println(simpleDateFormat.format(date));
                    }finally {
                        lock.unlock();
                    }
                }
            });
        }
        //  关闭线程池
        threadPool.shutdown();
    }

    /**
     *  使用ThreadLocal
     */
    @Test
    public void test04(){
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // 创建Lock锁
        Lock lock = new ReentrantLock();
        // 执行 10 次时间格式化
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            // 线程池执行任务
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    // 创建时间对象
                    Date date = new Date(finalI * 1000);
                    // 执行时间格式化并打印结果
                    lock.lock();
                    try{
                        System.out.println(simpleDateFormat.format(date));
                    }finally {
                        lock.unlock();
                    }
                }
            });
        }
        //  关闭线程池
        threadPool.shutdown();
    }

    // 创建 ThreadLocal 对象，并设置默认值（new SimpleDateFormat）
    private static ThreadLocal<SimpleDateFormat> threadLocal =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("mm:ss"));

    @Test
    public void test05() {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // 执行 10 次时间格式化
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            // 线程池执行任务
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    // 创建时间对象
                    Date date = new Date(finalI * 1000);
                    // 格式化时间
                    String result = threadLocal.get().format(date);
                    // 打印结果
                    System.out.println(result);
                }
            });
        }
        // 任务执行完之后关闭线程池
        threadPool.shutdown();
    }
}
