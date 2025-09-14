package top.wzh.boot.config.service.impl;

import enums.ResultStatus;
import jakarta.annotation.Resource;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import top.wzh.boot.config.model.Mail;
import top.wzh.boot.config.service.MailService;

import java.nio.charset.StandardCharsets;

/**
 * @Author: 王振辉
 * @Date: 2025/9/13
 */
@Service
public class MailServiceImpl implements MailService{
    //读取配置的发件人
    @Value("${spring.mail.username}")
    private String from;

    @Resource
    private JavaMailSender javaMailSender;

    @Override
    public ResultStatus sendSimpleMail(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(mail.getTo());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());

        try {
            javaMailSender.send(message);
            return ResultStatus.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultStatus.FAIL;
        }
    }

    /*发送html文件*/
    @Override
    public ResultStatus sendHtmlMail(Mail mail) {
        //TODO
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, false,
                    StandardCharsets.UTF_8.name());
            helper.setFrom(from);
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());

            helper.setText(mail.getContent(), true);
            javaMailSender.send(message);
            return ResultStatus.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultStatus.FAIL;
        }
    }
}