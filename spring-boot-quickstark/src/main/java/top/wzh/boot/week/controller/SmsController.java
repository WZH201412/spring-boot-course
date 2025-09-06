package top.wzh.boot.week.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wzh.boot.week.service.SmsService;

/**
 * @Author: 王振辉
 * @Date: 2025/9/6
 */
@RestController
public class SmsController {
    @Resource
    private SmsService smsService;

    @GetMapping("/sms")
    public String sendSms(String phone) {
        smsService.sendSms(phone);
        return phone;
    }

}
