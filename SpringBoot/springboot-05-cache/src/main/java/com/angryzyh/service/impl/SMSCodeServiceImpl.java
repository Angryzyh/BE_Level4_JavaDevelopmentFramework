package com.angryzyh.service.impl;

import com.angryzyh.model.SMSCode;
import com.angryzyh.service.SMSCodeService;
import com.angryzyh.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    /**
     *
     * @param tele 传入手机号码
     * @return 返回生成的随机6位验证码
     */
    @Override
    @CachePut(value = "smsCode", key = "#tele") //只能放不能取
    public String sendCodeToSMS(String tele) {
        return codeUtils.generator(tele);
    }

    /**
     *
     * @param smsCode 输入手机号和验证码
     * @return 获取验证码,默认返回值为null，只有当缓存有的时候才有值，最终比较是否相等
     */
    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = smsCode.getCode();
        //取出内存中的验证码与传递过来的验证码比对，如果相同，返回true ,以手机号为key,验证码为value
        String cacheCode = codeUtils.get(smsCode.getTele());
        return code.equals(cacheCode);
    }



    //以下是springboot中使用xmemcached

    /*@Autowired
    private MemcachedClient memcachedClient;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        try {
            memcachedClient.set(tele,10,code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = null;
        try {
            code = memcachedClient.get(smsCode.getTele()).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smsCode.getCode().equals(code);
    }*/

}














