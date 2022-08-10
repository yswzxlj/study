package com.example.mydockertest.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: lich
 * @Description:
 * @Date: 2022/8/2 15:36
 * @Version: v1.0
 */
@Controller
public class controller {
    @Autowired
    service service;
    
    @GetMapping("/add")
    @ResponseBody
    public void add(){
        service.add();
    }
            
}
