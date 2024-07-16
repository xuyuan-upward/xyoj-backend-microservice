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
@MapperScan(basePackages = "com.xuyuan.xyojbackendquestionservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
// 会覆盖@SpringBootApplication里面的扫描包
// 如果需要扫描其他模块下的包，需要按需加载
@ComponentScan(basePackages = {"com.xuyuan.xyojbackendquestionservice", "com.xuyuan.xyojbackendcommon.exception"})
//@ComponentScan("com.xuyuan.xyojbackendquestionservice")
//@ComponentScan("com.xuyuan")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.xuyuan.xyojbackendserviceclient.service"})
public class XyojBackendQuestionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyojBackendQuestionServiceApplication.class, args);
    }

}
