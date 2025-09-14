package top.wzh.boot.config.service;

import enums.ResultStatus;
import org.springframework.web.multipart.MultipartFile;
import top.wzh.boot.config.model.Mail;

public interface MailService {
    /**
     * 发送邮件
     * @param mail 邮件信息
     * @return
     */
    ResultStatus sendSimpleMail(Mail mail);

    /**
     * 发送HTML邮件
     * @param mail 邮件信息
     * @return
     */
    ResultStatus sendHtmlMail(Mail mail);

    /**
     * 发送带附件的邮件
     *
     * @param mail  邮件信息
     * @param files
     * @return
     */
    ResultStatus sendAttachmentsMail(Mail mail, MultipartFile[] files);
}
