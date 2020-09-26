package com.shapestone.spring.boot.java.starter.mw.infrastructure;

import com.shapestone.spring.boot.java.starter.mw.repository.GoodByeRepository;
import com.shapestone.spring.boot.java.starter.mw.repository.HelloRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootJavaStarterMWRepositoryConfig {

    @Bean
    public HelloRepository helloRepository() {
        return new PostgresHelloRepository();
    }

    @Bean
    public GoodByeRepository goodByeRepository() {
        return new PostgresGoodByeRepository();
    }

}
