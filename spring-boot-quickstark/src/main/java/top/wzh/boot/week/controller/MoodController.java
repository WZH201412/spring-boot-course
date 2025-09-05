package top.wzh.boot.week.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 王振辉
 * @Date: 2025/9/5
 */
@RestController
public class MoodController {
    @Value("${server.my.mood.today}")
    private String today;

    @Value("${server.my.mood.content}")
    private String content;

    @Value("${server.my.mood.author}")
    private String author;

    @GetMapping("/mood")
    public String getMood() {
        return "今天是：" + today + "，心情是：" + content + "，作者是：" + author;
    }
}
