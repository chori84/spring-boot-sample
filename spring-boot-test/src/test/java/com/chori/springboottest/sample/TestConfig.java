package com.chori.springboottest.sample;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {
    @Bean
    public String testBean() {
        return "TestBean";
    }
}
