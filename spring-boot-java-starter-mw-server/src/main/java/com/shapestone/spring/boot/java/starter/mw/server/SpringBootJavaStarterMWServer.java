package com.shapestone.spring.boot.java.starter.mw.server;

import com.shapestone.spring.boot.java.starter.mw.application.SpringBootJavaStarterMWApplicationConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

import static org.springframework.boot.SpringApplication.run;

import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Import(SpringBootJavaStarterMWApplicationConfig.class)
@EnableAutoConfiguration
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@Configuration
@EnableSwagger2
public class SpringBootJavaStarterMWServer {
    public static void main(String[] args) {
        run(SpringBootJavaStarterMWServer.class, args);
    }
}
