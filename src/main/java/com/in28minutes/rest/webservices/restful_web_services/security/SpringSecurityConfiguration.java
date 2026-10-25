package com.in28minutes.rest.webservices.restful_web_services.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {

//        1. All requests must be authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
//        2. If a request is not authenticated, a webpage is shown
        http.httpBasic(Customizer.withDefaults());
//        3.CSRF -> POST, PUT, DELETE
        http.csrf(csrf -> csrf.disable());


        return http.build();
    }
}
