package com.gooney;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.gooney.mapper")
@EnableScheduling//开启定时任务，自动扫描
@EnableAsync
public class SpringbootMybatis2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatis2Application.class, args);
    }

}
