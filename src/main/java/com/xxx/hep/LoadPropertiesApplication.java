package com.xxx.hep;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//手动加载自定义配置文件
// 方法一
@PropertySource(value = {
        "classpath:xxx.properties",
        "classpath:yyy.properties",
        "classpath:zzz.yaml",
}, encoding = "utf-8")

/**
 * @author hep
 */
@SpringBootApplication
@Component
public class LoadPropertiesApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoadPropertiesApplication.class,args);
    }
    @Value("${com.xxx.hep.xxx}")
    private String xxx;

    @Value("${com.xxx.hep.yyy}")
    private String yyy;

    @Value("${com.xxx.hep.zzz}")
    private String zzz;

    @Bean
    void index(){
        System.out.println(xxx);
        System.out.println(yyy);
        System.out.println(zzz);
    }
    
}
