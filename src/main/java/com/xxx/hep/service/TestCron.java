package com.xxx.hep.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hep
 */
@Service
@Slf4j
public class TestCron {

    @Scheduled(cron="0/30 * * * * ?")
    private void test(){
        System.err.println("这句话每30秒打印一次  "+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @Scheduled(cron = "0/1 * * * * ?")
    public void taskA() {
        log.info("taskA方法（这句话每1秒打印一次）"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @Scheduled(cron = "0/2 * * * * ?")
    public void taskB() {
        try {
            log.info("taskB方法（这句话每2秒打印一次）"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
