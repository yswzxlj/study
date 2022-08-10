package com.example.mydockertest.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: lich
 * @Description:
 * @Date: 2022/8/8 15:23
 * @Version: v1.0
 */
@Controller
public class test {
    @GetMapping("global")
    @ResponseBody
    public void test(){
        String[] strings = new String[]{"1"};
        String string = strings[5];


    }
}
