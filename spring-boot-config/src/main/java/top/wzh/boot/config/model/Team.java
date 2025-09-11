package top.wzh.boot.config.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @Author: 王振辉
 * @Date: 2025/9/11
 */

@Data
@Component
public class Team {
    @Value("${team.leader}")
    @NotNull
    @Length(min = 2,max = 10,message = "长度必须在2-10之间")
    private String leader;

    @Value("${team.phone}")
    @Pattern(regexp = "^[0-9]{11}$",message = "手机号格式不正确")
    private String phone;

    @Value("${team.age}")
    @Max(5)
    @Min(1)
    private Integer age;

    @Value("${team.createDate}")
    @Past(message = "创建时间必须早于当前时间")
    private LocalDate createDate;
}
