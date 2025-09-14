package top.wzh.boot.config.service;

import enums.ResultStatus;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.wzh.boot.config.model.Mail;

@SpringBootTest
class MailServiceTest {
    @Resource
    private MailService mailService;

    @Test
    void sendSimpleMail() {
        Mail mail = new Mail();
        mail.setTo("2258262190@qq.com");
        mail.setSubject("测试简单邮件");
        mail.setContent("测试邮件内容");

        ResultStatus resultStatus = mailService.sendSimpleMail(mail);
        System.out.println("返回状态 = " + resultStatus);   // 先打印
        assert resultStatus == ResultStatus.SUCCESS;
    }

}