package com.sysxx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
//@MapperScan(basePackages = {"com.sysxx.system.mapper"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }
}