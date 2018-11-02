package com.zoucai.zucai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Spring Boot核心注解，用于开启自动配置
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.zoucai.zucai.mapper")
@ComponentScan(basePackages = "com.zoucai.zucai.*")
public class SpringbootApplication {

    public static ConfigurableApplicationContext ac;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
