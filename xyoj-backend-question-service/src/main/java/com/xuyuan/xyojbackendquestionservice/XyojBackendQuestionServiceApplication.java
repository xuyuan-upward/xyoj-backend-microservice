package com.xuyuan.xyojbackendquestionservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.yupi.xyojbackendquestionservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.xuyuan")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.xuyuan.xyojbackendserviceclient.service"})
public class XyojBackendQuestionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyojBackendQuestionServiceApplication.class, args);
    }

}
