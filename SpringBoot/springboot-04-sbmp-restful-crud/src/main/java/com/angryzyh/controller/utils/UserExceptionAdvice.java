package com.angryzyh.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*异常处理器*/
@RestControllerAdvice
public class UserExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public R doException(Exception exception) {
        exception.printStackTrace();
        return new R(false,"服务器故障，请稍后再试！");
    }
}
