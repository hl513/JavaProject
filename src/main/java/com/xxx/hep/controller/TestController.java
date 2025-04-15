package com.xxx.hep.controller;

import com.xxx.hep.anno.MyAnnotation;
import com.xxx.hep.anno.MyLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hep
 */
@RestController
public class TestController {

    @MyAnnotation("aop测试")
    @RequestMapping("/")
    public String index(){
        return "欢迎访问 springboot-aop";
    }

    @MyAnnotation("test aop")
    @RequestMapping("/test")
    public String test(){
        return "欢迎访问 springboot-aop";
    }

    @MyLog("获取用户信息")
    @GetMapping("/info")
    public String getUserInfo() {
        return "User Info";
    }
    @MyLog("获取全部用户信息")
    @GetMapping("/findUser")
    public String findUser() {
        return "User";
    }


}
