package top.wzh.boot.config.model;

import lombok.Data;

import java.time.LocalDate;

/**
 * @Author: 王振辉
 * @Date: 2025/9/11
 */
@Data
public class Team {
    private String leader;
    private String phone;
    private Integer age;
    private LocalDate createDate;
}
