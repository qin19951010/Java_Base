package com.jiangnanyidianyu.Concurrency_HM;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author QinZhongliang
 * @date 2022年08月05日 10:00 AM
 */
@Slf4j
public class RunnableDemo {

    @Test
    public void test01(){
        Runnable r = () ->{
            log.info("调试信息~");
        };
        Thread t = new Thread(r);
        t.setName("thread_01");
        t.start();
    }
}
