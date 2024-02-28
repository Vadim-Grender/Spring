package com.example.exmpl4sem2CRUDaspects.config;

import com.example.exmpl4sem2CRUDaspects.aspects.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.example.exmpl4sem2CRUD")
@EnableAspectJAutoProxy
public class ProjectConfiguration {
    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}
