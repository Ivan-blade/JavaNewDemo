package com.ivan.service.mail;


import com.ivan.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hylu.ivan
 * @date 2022/3/11 上午12:05
 * @description
 */
public class MailServiceTest extends BaseTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testMain() {
        String mailAddress = "2734319366@qq.com";
        String content = "邮箱测试...";
        mailService.sendMail(mailAddress,"hello mail",content);
    }
}