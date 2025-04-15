package com.xxx.hep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @GetMapping("/mail/send-page")
    public String sendMailPage() {
        return "mail/send"; // 不加 .html 后缀
    }
}
