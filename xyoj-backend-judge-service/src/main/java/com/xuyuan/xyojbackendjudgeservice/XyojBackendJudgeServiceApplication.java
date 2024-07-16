package com.xuyuan.xyojbackendjudgeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
//@ComponentScan("com.xuyuan")
@ComponentScan(basePackages = {"com.xuyuan.xyojbackendcommon.exception","com.xuyuan.xyojbackendjudgeservice"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.xuyuan.xyojbackendserviceclient.service"})
public class XyojBackendJudgeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyojBackendJudgeServiceApplication.class, args);
    }

}
