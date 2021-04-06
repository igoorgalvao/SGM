package com.cidadao.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableFeignClients
@SpringBootApplication
public class CidadaoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CidadaoApiApplication.class, args);
	}

}
