package top.wzh.boot.week.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 王振辉
 * @Date: 2025/9/5
 */
@RestController
public class HelloController {
    @Value("${server.feature.helloSwitch}")
    private boolean isHelloEnabled;

    @Value("${server.feature.closeMsg}")
    private String closeMsg;

    @GetMapping("/hello")
    public String hello() {
        if (isHelloEnabled) {
            return "接口开放中！欢迎访问我的第一个 Spring Boot 项目";
        } else {
            return closeMsg;
        }
    }


//    @GetMapping("/hello")
//    public String hello(){
//        return "hello world!";
//    }

    @GetMapping("/list")
    public List<String> list(){
        return List.of("1","2","3");
    }
}
