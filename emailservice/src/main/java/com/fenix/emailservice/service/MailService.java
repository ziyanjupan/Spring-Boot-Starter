package com.fenix.emailservice.service;

/**
 * @Author: xiaguangyong
 * @ClassName: MailService
 * @Description: mail service interface
 * @Date: 2019/7/9 16:33
 * @Version: 1.0
 * @Modify:
 */
public interface MailService {
    void sendSimpleMail(String to, String subject, String content);
}
