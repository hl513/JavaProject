package com.xxx.hep.pojo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author hep
 */
@Data
public class MailRequest {
    public String to;
    public String subject;
    public String content; // 简单邮件用
    public String username; // HTML 邮件用
    public List<MultipartFile> filePaths; // 附件邮件用
}
