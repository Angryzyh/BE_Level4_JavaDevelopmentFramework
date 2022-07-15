package com.angryzyh.service.impl;

import com.angryzyh.model.SMSCode;
import com.angryzyh.service.SMSCodeService;
import com.angryzyh.utils.CodeUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

  /*  @CreateCache(area = "sms",name = "jetcache_",expire = 10,timeUnit = TimeUnit.SECONDS)
    private Cache<String, String> jetcache;

    *//**
     * @param tele 传入手机号码
     * @return 返回生成的随机6位验证码
     *//*
    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        jetcache.put(tele, code);
        return code;
    }

    *//**
     *
     * @param //smsCode 输入手机号和验证码
     * @return 获取验证码,默认返回值为null，只有当缓存有的时候才有值，最终比较是否相等
     *//*
    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = jetcache.get(smsCode.getTele());
        return smsCode.getCode().equals(code);
    }*/

    @Autowired
    private CacheChannel cacheChannel;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        cacheChannel.set("sms", tele, code);
        return code;
    }


    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = cacheChannel.get("sms",smsCode.getTele()).asString();
        return smsCode.getCode().equals(code);
    }
}














