package com.xinyan.boot;

import com.xinyan.boot.config.DemoMetrics;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author 孟星魂
 * @version 5.0 createTime: 2019/5/10
 */
@SpringBootApplication
@ImportResource({"classpath:spring/applicationContext.xml"})
@ComponentScan(basePackages={"com.xinyan.boot"})
@MapperScan(basePackages = {"com.xinyan.boot.mapper"})
@EnableEurekaClient
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
    }

    @Bean
    public DemoMetrics demoMetrics(){
        return new DemoMetrics();
    }
}
