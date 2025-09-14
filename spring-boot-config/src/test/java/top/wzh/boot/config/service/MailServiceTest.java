package top.wzh.boot.config.service;

import enums.ResultStatus;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import top.wzh.boot.config.model.Mail;

import java.io.File;
import java.io.IOException;

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
    /* ---------------- 2. HTML 邮件 ---------------- */
    @Test
    void sendHTMLMail() {
        Mail mail = new Mail();
        mail.setTo("2258262190@qq.com");
        mail.setSubject("测试HTML邮件");
        String content = """
                            <!DOCTYPE html>
                            <html>
                            <head>
                              <meta charset="UTF-8">
                              <style>
                                body{font-family:Microsoft YaHei;background:#f6f8fa;margin:0;}
                                .container{max-width:600px;margin:30px auto;background:#fff;border-radius:8px;box-shadow:0 2px 8px rgba(0,0,0,.1);}
                                .header{background:#2d8cf0;color:#fff;text-align:center;padding:20px;font-size:24px;font-weight:bold;}
                                .content{padding:30px;color:#333;line-height:1.6;}
                                .button{display:inline-block;margin:20px 0;padding:12px 28px;background:#2d8cf0;color:#fff;text-decoration:none;border-radius:4px;}
                                .footer{background:#f1f1f1;text-align:center;font-size:12px;color:#666;padding:15px;}
                              </style>
                            </head>
                            <body>
                              <div class="container">
                                <div class="header">账号注册成功确认</div>
                                <div class="content">
                                  <h2>亲爱的用户，欢迎加入！</h2>
                                  <p>您的账号已经注册成功，请点击下方按钮完成邮箱确认：</p>
                                  <a href="https://example.com/verify?token=xxxxxx" class="button">确认我的邮箱</a>
                                  <p>为了保障您的账号安全，本链接将在 <b>24 小时内失效</b>。</p>
                                </div>
                                <div class="footer">©2025 示例平台 · 本邮件由系统自动发送，请勿直接回复</div>
                              </div>
                            </body>
                            </html>
                            """;
        mail.setContent(content);
        mailService.sendHtmlMail(mail);
    }

    /* ---------------- 3. 带附件邮件 ---------------- */
    @Test
    void sendAttachmentsMail() throws IOException {
        Mail mail = new Mail();
        mail.setTo("2258262190@qq.com");
        mail.setSubject("测试带附件的邮件");
        mail.setContent("带附件的邮件内容");

        // 准备两个本地文件（换成你电脑里真实存在的文件）
        File file1 = new File("C:\\Users\\王振辉\\Desktop\\桌面\\摄影\\摄影\\IMG_20220901_172316.jpg");
        File file2 = new File("C:\\Users\\王振辉\\Desktop\\桌面\\摄影\\摄影\\mmexport1693970719665.jpg");

        MultipartFile[] files = new MultipartFile[2]; {
            files[0] = new MockMultipartFile(
                    file1.getName(),
                    file2.getName(),
                    "image/jpeg",
                    FileCopyUtils.copyToByteArray(file1)
            );
            files[1] = new MockMultipartFile(
                    file2.getName(),
                    file2.getName(),
                    "image/jpeg",
                    FileCopyUtils.copyToByteArray(file2)
            );
            mailService.sendAttachmentsMail(mail, files);
        }
    }

}