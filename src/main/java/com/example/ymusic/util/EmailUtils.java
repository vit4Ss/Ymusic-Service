package com.example.ymusic.util;

import com.example.ymusic.domain.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class EmailUtils {


    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(Email email){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        if(email.getSendEmail().size()==0){
            log.info("收件人为空");
        }
        else{
            simpleMailMessage.setFrom("17671298856@163.com");
            simpleMailMessage.setTo(email.getSendEmail().toArray(new String[email.getSendEmail().size()])); //设置接收邮件的人，可以多个
            simpleMailMessage.setSubject(email.getTitle()); //设置发送邮件的主题.
            simpleMailMessage.setText(email.getText()); //设置发送邮件的内容
        }
        mailSender.send(simpleMailMessage);
    }

}
