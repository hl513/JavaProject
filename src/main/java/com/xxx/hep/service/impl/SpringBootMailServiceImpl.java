package com.xxx.hep.service.impl;

import com.xxx.hep.service.SpringBootMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service
class SpringBootMailServiceImpl implements SpringBootMailService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送方
     */
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送简单邮件
     *
     * @param to      接收方
     * @param subject 邮件主题
     * @param text    邮件内容
     */
    @Override
    public void sendSimpleMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }

    /**
     * 发送HTML格式的邮件
     *
     * @param to      接收方
     * @param subject 邮件主题
     * @param content HTML格式的邮件内容
     * @throws MessagingException
     */
    @Override
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        //true表示需要创建一个multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        // 设置是否发送html格式
        helper.setText(content, true);

        mailSender.send(message);
    }

    /**
     * 发送HTML格式的邮件，并可以添加附件
     * @param to      接收方
     * @param subject 邮件主题
     * @param content HTML格式的邮件内容
     * @param files   附件
     * @throws MessagingException
     */
    @Override
    public void sendAttachmentsMail(String to, String subject, String content, List<File> files) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        //添加附件
        for(File file : files){
            helper.addAttachment(file.getName(), new FileSystemResource(file));
        }

        mailSender.send(message);
    }
}