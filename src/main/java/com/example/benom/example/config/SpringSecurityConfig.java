package com.example.benom.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable()).cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.disable()).authorizeHttpRequests(
                authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                            .anyRequest()
                            .authenticated();
                }).httpBasic(httpSecurityHttpBasicConfigurer -> httpSecurityHttpBasicConfigurer.init(http));
        return http.build();


    }
}
