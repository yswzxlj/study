package com.example.mydockertest.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: lich
 * @Description:
 * @Date: 2022/8/4 17:59
 * @Version: v1.0
 */
@Component
public abstract class redisUtils {
    @Autowired
    private Redisson redisson;
    
    public abstract void doBusiness() throws InterruptedException;
    //正常完成
    private String status_0 = "0";
    //拿不到锁
    private String status_1 = "1";
    //异常 
    private String status_2 = "2";
     

    public final String redisLockExecute(String redisKey) {
        RLock lock = redisson.getLock(redisKey);
        
        try {
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                doBusiness();
            } else {
                return status_1;
            }

            return  status_0;
        } catch (Exception e) {
            return status_2;
        } finally {
            if (lock.isLocked()) { // 是否还是锁定状态
                if (lock.isHeldByCurrentThread()) { // 是当前执行线程的锁
                    lock.unlock(); // 释放锁
                }

            }
        }
    }
    
}
