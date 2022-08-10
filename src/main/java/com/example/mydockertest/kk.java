package com.example.mydockertest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: lich
 * @Description:
 * @Date: 2022/7/28 19:02
 * @Version: v1.0
 */
@Controller
public class kk {
    
    @Autowired
    private RestTemplate restTemplate;
    
    
    @GetMapping("test")
    @ResponseBody
    @ApiOperation("测试方法")
    public  String t(@ApiParam("id呀") String id){
        return id + "11111";
    }

    @GetMapping("restTest")
    @ResponseBody
    @ApiOperation("restTemplate")
    public  String rest(){
        return  restTemplate.getForObject("https://so.csdn.net/api/v1/topword?q=python" ,String.class).toString();
    }
    
}
