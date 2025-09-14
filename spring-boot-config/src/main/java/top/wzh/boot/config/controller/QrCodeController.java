package top.wzh.boot.config.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.codec.Base62;
import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: 王振辉
 * @Date: 2025/9/12
 */
@RestController
@RequestMapping("/qrcode")
public class QrCodeController {
    @Value("${custom.qrcode.content}")
    private String content;


    @GetMapping("/generate")
    public ResponseEntity<byte []> generateQrCode(){
        //字节数组输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        QrCodeUtil.generate(content, 300, 300, ImgUtil.IMAGE_TYPE_PNG,out);
        byte[] bytes = out.toByteArray();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(bytes,headers, HttpStatus.OK);
    }

    @GetMapping("/generate{text}")
    public ResponseEntity<byte []> generateQrCode(@PathVariable String text){
        //字节数组输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        QrCodeUtil.generate(text, 300, 300, ImgUtil.IMAGE_TYPE_PNG,out);
        byte[] bytes = out.toByteArray();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(bytes,headers, HttpStatus.OK);
    }

    /**
     * 随机图形验证码
     * @return
     */
    @GetMapping("/captcha")
    public Map<String,String> captcha() throws IOException {
        // 生成 200×100 的 4 位数字验证码
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100, 4, 20);
        Map<String,String> map = new HashMap<>();
        map.put("code", lineCaptcha.getCode());     // 正确答案（后端可存 session）
        map.put("image", lineCaptcha.getImageBase64Data()); // base64 图片
        return map;
    }

    /**
     * 短链接
     * @param size
     * @return
     */
    private final AtomicLong counter = new AtomicLong(1000);

    @GetMapping("/short")
    public List<String> shortUrl(@RequestParam(defaultValue = "5") int size){
        return IntStream.range(0, size)
                .mapToObj(i -> Base62.encode(String.valueOf(counter.incrementAndGet())))
                .collect(Collectors.toList());
    }

    /**
     * 沙雕文案
     * @return
     */
    private final List<String> 文案 = List.of("我裂开了","真香警告","耗子尾汁","芜湖起飞");
    @GetMapping("/meme-text")
    public Map<String,String> memeText(){
        return Map.of("今日沙雕文案", RandomUtil.randomEle(文案));
    }

    /**
     * 时间戳
     * @return
     */
    @GetMapping("/fany-date")
    public Map<String,String> fanyDate(){
        DateTime dt = DateUtil.date();
        return Map.of("凡尔赛时间", DateUtil.format(dt,"yyyy年MM月dd日 E HH点mm分"),
                "农历", new ChineseDate(dt).toString());
    }

    /**
     * 运势
     * @param name
     * @return
     */

    private final String[] 签 = {"上上签","上签","中签","下签","下下签"};
    @GetMapping("/fortune")
    public Map<String,String> fortune(@RequestParam String name){
        return Map.of("姓名", name,
                "今日运势", RandomUtil.randomEle(签),
                "幸运数字", RandomUtil.randomNumbers(3));
    }
}
