package com.xxx.hep.aspect;

import com.xxx.hep.anno.MyLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class MyLogAspect {
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    // 切点：匹配所有标注了 @MyLog 的方法
    @Pointcut("@annotation(com.xxx.hep.anno.MyLog)")
    public void logPointcut() {}

    // 前置通知：方法执行前执行
    @Before("logPointcut()")
    public void beforeMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        MyLog myLog = method.getAnnotation(MyLog.class);
        logger.info("执行方法前，操作描述: " + myLog.value());
        logger.info("方法名: " + method.getName());
        logger.info("参数: " + Arrays.toString(joinPoint.getArgs()));
    }
}
