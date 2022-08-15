package com.example.mydockertest.handlers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: lich
 * @Description:
 * @Date: 2022/8/8 15:21
 * @Version: v1.0
 */

/*@RestControllerAdvice*/
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
        return  "抓到报错" + e;
    }
}
