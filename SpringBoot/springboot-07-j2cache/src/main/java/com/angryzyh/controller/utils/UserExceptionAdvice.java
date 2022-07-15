package com.angryzyh.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*异常处理器*/
@RestControllerAdvice
public class UserExceptionAdvice {

    @ExceptionHandler({Exception.class})
    public R doException(Exception exception) {
        exception.printStackTrace();
        return new R(false,"服务器故障，请稍后再试！");
    }

    /*@ExceptionHandler(IllegalArgumentException.class)
    @Cacheable(value = "smsCode",key="#tele")
    public R codeException(IllegalArgumentException exception,String tele) {
        if (tele == null) {
            exception.printStackTrace();
            return new R(false, "验证码已经失效，请重新发送！");
        }
        return doException(exception);
    }*/
}
