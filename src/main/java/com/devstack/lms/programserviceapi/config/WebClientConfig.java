package com.devstack.lms.programserviceapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }


    @Bean
    public JwtDecoder jwtDecoder(){
        String issuerUri = "http://localhost:8080/realms/lms";
        return NimbusJwtDecoder.withIssuerLocation(issuerUri).build();
    }


}
