package top.wzh.boot.config.controller;

import enums.ResultStatus;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
