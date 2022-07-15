package com.angryzyh.service;

import com.angryzyh.model.SMSCode;

public interface SMSCodeService {

    /**
     *
     * @param tele 传入手机号码
     * @return 得到验证码
     */
    public String sendCodeToSMS(String tele);

    /**
     * @
     * @param smsCode 输入手机号和验证码
     * @return 判断是否验证成功
     */
    public boolean checkCode(SMSCode smsCode);
}
