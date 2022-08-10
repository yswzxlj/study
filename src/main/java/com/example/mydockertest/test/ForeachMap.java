package com.example.mydockertest.test;

import java.util.HashMap;

/**
 * @Auther: lich
 * @Description:
 * @Date: 2022/8/1 16:24
 * @Version: v1.0
 */
public class ForeachMap {
    public static void main(String[] args) {
        HashMap<String, String> stringStringHashMap = new HashMap(){{
            put("test" , "1");
            put("test2" , "2");
        }};

        stringStringHashMap.forEach((key , value)->{
            System.out.println(key +"," + value);
        });
        
    }
}
