package top.wzh.boot.week.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 王振辉
 * @Date: 2025/9/5
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello world!";
    }

    @GetMapping("/list")
    public List<String> list(){
        return List.of("1","2","3");
    }
}
