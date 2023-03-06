package com.bosonit.backend.configuration;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    @Bean
    public Faker getFaker() {
        return new Faker();
    }
    @Bean
    public InitialData getInitialData() {return new InitialData();}
}