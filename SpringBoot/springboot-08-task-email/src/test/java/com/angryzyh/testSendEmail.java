package com.angryzyh;

import com.angryzyh.email.service.SendEmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testSendEmail {
    @Autowired
    SendEmailService sendEmailService;

    @Test
    public void testSendEmail() {
        sendEmailService.sendEmail();
    }

}
