package com.sankalp.sankalp_tracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/graphql")
                .allowedOriginPatterns("http://localhost:3000", "https://*.ngrok-free.app", "https://36e69b99ddc8.ngrok-free.app")
                .allowedMethods("GET", "POST", "OPTIONS")
                .allowedHeaders("Content-Type", "Authorization")
                .exposedHeaders("Authorization")
                .allowCredentials(true);
    }
}