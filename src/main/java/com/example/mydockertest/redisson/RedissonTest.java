package com.example.mydockertest.redisson;

import com.google.common.base.Stopwatch;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;


/**
 * @Auther: lich
 * @Description:
 * @Date: 2022/8/4 15:58
 * @Version: v1.0
 */
@Controller
@Slf4j
public class RedissonTest extends redisUtils{
    
    @GetMapping("/redisson/test/{type}")
    @ApiOperation("radisson分布式锁测试")
    @ResponseBody
    public String test(@PathVariable String type){
        MDC.put("type" , type);
        log.info("请求type");
        
        return super.redisLockExecute("lchtest");
    }

    @Override
    public void doBusiness() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        log.info("执行具体业务");
        Thread.sleep(10000);
        log.info("耗时{}" , stopwatch.elapsed(TimeUnit.SECONDS));
    }
}
