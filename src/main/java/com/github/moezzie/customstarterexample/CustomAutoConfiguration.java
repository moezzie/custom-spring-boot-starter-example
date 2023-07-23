package com.github.moezzie.customstarterexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({CustomProperties.class})
public class CustomAutoConfiguration {

    @Bean
    public CustomBean customBean(@Value("${custom.starter.beanName:CustomBean}") String name) {
        return new CustomBean(name);
    }
}
