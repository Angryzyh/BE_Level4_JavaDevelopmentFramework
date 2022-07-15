package com.angryzyh.email.service.impl;

import com.angryzyh.email.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    @SuppressWarnings("all")
    private JavaMailSender javaMailSender;

    //发送人
    private String from = "1792090548@qq.com";
    //接收人
    private String to = "1941988722@qq.com";
    //标题
    private String subject = "龙龙哥哥我想你了";
    //正文
    private String context = "啊~~~~~~人家想你了";

    @Override
    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from+"(龙龙小迷妹)");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);
        System.out.println(message);
        javaMailSender.send(message);
    }


    //发送人
    private String from1 = "1792090548@qq.com";
    //接收人
    private String to1 = "1941988722@qq.com";
    //标题
    private String subject1 = "骚龙伏法";
    //正文
    private String context1 = "<span color='red'>FBI warring</span><a href='https://xw.qq.com/cmsid/20210207A077WW00'>大罗法杖，点击详情</a><br><img src='https://img1.baidu.com/it/u=4018609370,2551181541&fm=253&fmt=auto&app=138&f=JPEG?w=1173&h=500'>";
    //文件
    private File file1 = new File("D:\\workspace\\IDEAworkspaces\\Angryzyh\\BE_Level4_JavaDevelopmentFramework\\SpringBoot\\springboot-08-task-email\\src\\main\\resources\\static\\favicon.ico");
    @Override
    @Scheduled(cron = "*/15 * * * * *")
    public void sendEmailWithFile() {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,true);
            mimeMessageHelper.setFrom(from1+"(骚龙挨打)");
            mimeMessageHelper.setTo(to1);
            mimeMessageHelper.setSubject(subject1);
            mimeMessageHelper.setText(context1,true);
            mimeMessageHelper.addAttachment("favicon.png",file1);
        } catch (MessagingException e) {
            e.printStackTrace();
        }finally {
            System.out.println(message);
        }
        javaMailSender.send(message);
    }
}
