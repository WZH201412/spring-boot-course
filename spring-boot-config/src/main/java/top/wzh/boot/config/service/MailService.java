package top.wzh.boot.config.service;

import enums.ResultStatus;
import top.wzh.boot.config.model.Mail;

public interface MailService {
    /**
     * 发送邮件
     * @param mail 邮件信息
     * @return
     */
    ResultStatus sendSimpleMail(Mail mail);
}
