package top.wzh.boot.week.service;

/**
 * @author wzh
 * @date 2025/9/5
 */
public interface SmsService {
    /**
     * 发送短信
     *
     *
     * @param phone 手机号
     */
    void sendSms(String phone);
}
