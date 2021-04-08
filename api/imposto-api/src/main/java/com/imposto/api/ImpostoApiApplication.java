package com.imposto.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableFeignClients
@SpringBootApplication
public class ImpostoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImpostoApiApplication.class, args);
	}

}
