package com.xxx.hep.controller;

import com.xxx.hep.pojo.MailRequest;
import com.xxx.hep.service.SpringBootMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private SpringBootMailService springBootMailService;

    @Autowired
    private TemplateEngine templateEngine;

    @PostMapping("/simple")
    public String sendSimpleMail(@RequestBody MailRequest request) {
        springBootMailService.sendSimpleMail(request.to, request.subject, request.content);
        return "简单邮件发送成功";
    }

    @PostMapping("/html")
    public String sendHtmlMail(@RequestBody MailRequest request) throws MessagingException {
        Context context = new Context();
        context.setVariable("username", request.username);
        String htmlContent = templateEngine.process("mail/mail", context);
        springBootMailService.sendHtmlMail(request.to, request.subject, htmlContent);
        return "HTML邮件发送成功";
    }

    @PostMapping("/upload-attachment")
    public String sendMailWithUpload(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String username,
            @RequestParam("files") List<MultipartFile> multipartFiles) throws Exception {

        Context context = new Context();
        context.setVariable("username", username);
        String content = templateEngine.process("mail/send", context);

        List<File> attachments = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            File tempFile = File.createTempFile("upload-", multipartFile.getOriginalFilename());
            multipartFile.transferTo(tempFile);
            attachments.add(tempFile);
        }

        springBootMailService.sendAttachmentsMail(to, subject, content, attachments);

        // 可选：清理临时文件
        for (File file : attachments) {
            file.delete();
        }

        return "发送成功（上传文件）";
    }

}
