package com.example.demo;

import cn.dev33.satoken.SaManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class Demo1Application {

//    @RequestMapping("/hello")
//    public String index(){
//        return "Hello World， Spring boot is good";
//    }

    public static void main(String[] args)  throws JsonProcessingException {
        SpringApplication.run(Demo1Application.class, args);
        System.out.println("启动成功，Sa-Token 配置如下：" + SaManager.getConfig());
    }

}
