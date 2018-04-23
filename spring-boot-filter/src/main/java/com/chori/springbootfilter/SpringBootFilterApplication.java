package com.chori.springbootfilter;

import com.chori.springbootfilter.user.MyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@ServletComponentScan
public class SpringBootFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFilterApplication.class, args);
    }
}
