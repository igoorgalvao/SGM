package com.imposto.api.client;

import feign.Logger;
import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsultaViaCepConfig {

    private static final int CINCO_SEGUNDOS = 5000;

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(CINCO_SEGUNDOS, CINCO_SEGUNDOS);
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(1000L, 1000L, 3);
    }
}