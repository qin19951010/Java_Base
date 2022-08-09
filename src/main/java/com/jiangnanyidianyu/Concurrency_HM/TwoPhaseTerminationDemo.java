package com.jiangnanyidianyu.Concurrency_HM;

import lombok.extern.slf4j.Slf4j;

/**
 * 两阶段终止模式
 * @author QinZhongliang
 * @date 2022年08月05日 4:15 PM
 */
@Slf4j
public class TwoPhaseTerminationDemo {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.start();

        Thread.sleep(3500);
        twoPhaseTermination.stop();
    }
}

@Slf4j
class TwoPhaseTermination{

    //监控线程
    private Thread monitor;

    //启动监控线程
    public void start(){
        monitor = new Thread(()->{
            while (true){
                Thread currentThread = Thread.currentThread();
                if(currentThread.isInterrupted()){
                    log.info("处理后事...");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.info("执行监控记录...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //重新设置打断标记
                    currentThread.interrupt();
                }
            }
        });
        monitor.start();
    }

    //停止监控线程
    public void stop(){
        monitor.interrupt();
    }
}
