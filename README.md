## 0.1.0 Spring Boot 学习仓库
### 1.创建新项目
#### 心情语录
#### 功能开关
#### 容联云配置
### 2.创建新模块
#### 2.1 自定义配置，心情语录
##### 2.1.1 各个的配置
1. yml文档编写
   my:
   mood:
   today: 周五
   content: 期待周末
   author: "码农"
2. cotroller/MoodController.java
##### 2.1.2 测试
1. 测试返回内容
   今天是：周五，心情是：期待周末，作者是：码农 
#### 2.2 功能开关
1. yml文档编写
   feature:
   helloSwitch: true
   closeMsg: "该接口正在维护，请10分钟后再来！！"
2. controller/HelloWorldController.java
### 2.3 容联云配置
#### 2.3.1 新建config模块包 CloopenConfig配置文档
#### 2.3.2 service包存储容联云服务
#### 2.3.3 SmsService实现接口
#### 2.3.4 SmsServiceImpl实现类
#### 2.3.5 yml编写

```
wzhy: 
    sms:
        ccp:
            serverIp: app.cloopen.com
            port: 8883
            accountSId: 2c94811c9860a9c4019919ec7e9b1fef
            accountToken: 3e53fb9d5344473d81f2996f168553e7
            appId: 2c94811c9860a9c4019919ec800a1ff6
            templateId: 1
```
### 3.查询
1. 创建查询模块  @GetMapping 查询
2. @PostMapping 新增
3. @DeleteMapping 删除
4. @PutMapping 修改