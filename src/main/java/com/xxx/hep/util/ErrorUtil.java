package com.xxx.hep.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorUtil {

    /**
     * 将异常信息转换为字符串，包括堆栈信息
     * @param e 异常对象
     * @return 异常堆栈信息字符串
     */
    public static String errorInfoToString(Throwable e) {
        if (e == null) {
            return "Exception is null";
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
