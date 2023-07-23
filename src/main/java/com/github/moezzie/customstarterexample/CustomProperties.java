package com.github.moezzie.customstarterexample;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "custom.starter")
public class CustomProperties {
    private String beanName = "CustomBean";
}
