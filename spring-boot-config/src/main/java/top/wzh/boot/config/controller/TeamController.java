package top.wzh.boot.config.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.wzh.boot.config.model.Team;

/**
 * @Author: 王振辉
 * @Date: 2025/9/11
 */
@RestController
public class TeamController {
    // 添加团队,并添加校验，返回规范的响应信息
    @PostMapping("/team")
    public ResponseEntity<Team> addTeam(@Valid @RequestBody Team team){
        return ResponseEntity.ok(team);
    }
}
