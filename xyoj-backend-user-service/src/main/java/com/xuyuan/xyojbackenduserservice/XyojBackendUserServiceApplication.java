package com.xuyuan.xyojbackenduserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan("com.xuyuan.xyojbackenduserservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
//@ComponentScan("com.xuyuan")
//@ComponentScan(basePackages = {"com.xuyuan","com.xuyuan.xyojbackenduserservice"})
@ComponentScan(basePackages = {"com.xuyuan.xyojbackenduserservice", "com.xuyuan.xyojbackendcommon.exception"})
@EnableDiscoveryClient
@EnableRedisHttpSession
@EnableFeignClients(basePackages = {"com.xuyuan.xyojbackendserviceclient.service"})
public class XyojBackendUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyojBackendUserServiceApplication.class, args);
    }

}
