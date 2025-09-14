package top.wzh.boot.config.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @Author: 王振辉
 * @Date: 2025/9/13
 */
@Data
public class Mail {
    @NotBlank
    @Email
    private String to;

    @NotBlank
    private String subject;

    @NotBlank
    private String content;
}
