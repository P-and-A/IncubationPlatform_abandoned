package com.incubationplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.incubationplatform.mapper")
public class IncubationPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncubationPlatformApplication.class, args);
	}
}
