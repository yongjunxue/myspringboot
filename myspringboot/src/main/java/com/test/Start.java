package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})//需要添加一个exclude条件，不让DataSource自动配置，否则启动时会报错
public class Start {
	public static void main(String[] args) {
        // http://localhost:8080/
        SpringApplication.run(Start.class, args);
    }
}
