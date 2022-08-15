package com.example.mydockertest.java8Thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: lich
 * @Description:
 * @Date: 2022/8/10 18:53
 * @Version: v1.0
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        // 1. 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        

        CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("开始线程");
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;

        }, executorService).thenApply(number -> {
            System.out.println("不用等线程");
            System.out.println(number + 100);
            return number + 100;
        });

        
        
        executorService.shutdown();
    }
}
