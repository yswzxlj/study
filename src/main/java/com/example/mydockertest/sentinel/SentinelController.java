package com.example.mydockertest.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: lich
 * @Description: sentinel学习
 * @Date: 2022/8/15 14:23
 * @Version: v1.0
 */
@Controller
@RequestMapping("/sentinel")
public class SentinelController {
    
    @RequestMapping("/testSentinel")
    @SentinelResource(value = "testSentinel" , blockHandler = "blockHandler",fallback = "fallHandler")
    @ResponseBody
    public String testSentinel(String name) throws Exception {
        if(name == null){
            throw new Exception("eee");
        }
        return "正常访问";
    }
    
    public String blockHandler(String name ,BlockException e){
        return name + "被限流";
    }

    public String fallHandler(String name){
        return name + "出错";
    }
    
}

