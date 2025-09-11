package top.wzh.boot.config.service;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    /**
     * 文件上传
     *
     * @param file 文件
     */
    String upload(MultipartFile file);


    @RestController
    @RequestMapping("/oss")
    public class OssController {
        @Resource
        private OssService ossService;

        @PostMapping("upload")
        public String upload(MultipartFile file) {
            return ossService.upload(file);
        }
    }
}