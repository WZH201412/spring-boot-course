package top.wzh.boot.config.controller;

import enums.ResultStatus;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.wzh.boot.config.aip.ApiResponse;
import top.wzh.boot.config.model.Mail;
import top.wzh.boot.config.service.MailService;

/**
 *@Author: 王振辉
 *@Date: 2025/9/14
 */
@RestController
@RequestMapping("/mail")
public class MailController {
    @Resource
    private MailService mailService;

    @PostMapping("/simple")
    public ResponseEntity<ApiResponse<ResultStatus>> sendSimpleMail(@Valid @RequestBody Mail mail){
        ResultStatus status = mailService.sendSimpleMail(mail);
        if (status == ResultStatus.SUCCESS){
            return ResponseEntity.ok(ApiResponse.success("发送成功", status));
        }
        return ResponseEntity.ok(ApiResponse.error("发送失败"));
    }

    /**
     * 发送HTML邮件
     * @param mail
     * @return
     */
    @PostMapping("/html")
    public ResponseEntity<ApiResponse<ResultStatus>> sendHtmlMail(@Valid @RequestBody Mail mail){
        ResultStatus status = mailService.sendHtmlMail(mail);
        if (status == ResultStatus.SUCCESS){
            return ResponseEntity.ok(ApiResponse.success("发送成功", status));
        }
        return ResponseEntity.ok(ApiResponse.error("发送失败"));
    }

    /**
     * 发送带附件的邮件
     * @param mail
     * @param files
     * @return
     */
    @PostMapping(value = "/attachments", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<ResultStatus>> sendAttachmentsMail(@Valid @RequestPart("mail") Mail mail,
                                                                         @RequestPart("files") MultipartFile[] files){
        ResultStatus status = mailService.sendAttachmentsMail(mail, files);
        return status == ResultStatus.SUCCESS ?
                ResponseEntity.ok(ApiResponse.success("发送成功", status)) :
                ResponseEntity.badRequest().body(ApiResponse.error("发送失败"));
    }
}
