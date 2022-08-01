package com.jiangnanyidianyu.多线程.JUC;

import com.jiangnanyidianyu.多线程.User;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author QinZhongliang
 * @date 2022年07月29日 3:38 PM
 */
public class testCompletableFuture {

    @Test
    public void testCompletableFuture(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> rFuture = CompletableFuture
                .runAsync(() -> System.out.println("1====>" + "hello siting"), executor);
        //supplyAsync的使用
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> {
                    System.out.print("2====>" + "hello ");
                    return "siting";
                }, executor);

        //阻塞等待，runAsync 的future 无返回值，输出null
        System.out.println("3====>" + rFuture.join());
        //阻塞等待
        String name = future.join();
        System.out.println("4====>" + name);
        executor.shutdown(); // 线程池需要关闭
    }

    @Test
    public void test(){
//        User user = new User();
//        user.setName("111");
//        if(user.getId() == 2){
//            System.out.printf("111");
//        }
        String ipKey = String.format("%s#%s", "className", "name");
        System.out.println(ipKey);
    }
}
