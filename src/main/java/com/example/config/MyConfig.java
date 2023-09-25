package com.example.config;

import com.example.controller.MyController;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyConfig {
    private MyController myController;

    @Bean
    public void config() {}
}
