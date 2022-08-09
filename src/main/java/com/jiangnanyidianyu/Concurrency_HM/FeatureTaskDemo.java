package com.jiangnanyidianyu.Concurrency_HM;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author QinZhongliang
 * @date 2022年08月05日 10:05 AM
 */
@Slf4j
public class FeatureTaskDemo {

    @Test
    public void test01() throws ExecutionException, InterruptedException {
        //任务对象
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.info("running......");
                Thread.sleep(1000);
                return 100;
            }
        });
        Thread t1 = new Thread(task,"t1");
        t1.start();
        log.info("{}",task.get());
    }
}
