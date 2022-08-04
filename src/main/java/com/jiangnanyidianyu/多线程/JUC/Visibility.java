package com.jiangnanyidianyu.多线程.JUC;

/**
 * @author QinZhongliang
 * @date 2022年08月02日 2:17 PM
 */
public class Visibility {
//    private static volatile boolean isOver = false;
    private static boolean isOver = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver) ;
            }
        });
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
    }
}
