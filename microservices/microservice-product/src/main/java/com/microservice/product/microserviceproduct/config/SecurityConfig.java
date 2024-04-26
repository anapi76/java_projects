package com.microservice.product.microserviceproduct.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.microservice.product.microserviceproduct.domain.service.JwtService;
import com.microservice.product.microserviceproduct.security.JwtTokenValidator;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity 
public class SecurityConfig {

    private JwtService jwtService;

    public SecurityConfig(JwtService jwtService) {
        this.jwtService = jwtService;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                    http.requestMatchers(HttpMethod.GET, "/product/*").authenticated();
                    http.requestMatchers(HttpMethod.POST, "/product/create").authenticated();
                    http.requestMatchers(HttpMethod.PUT, "/product/update/*").authenticated();
                    http.requestMatchers(HttpMethod.DELETE, "/product/delete/*").authenticated();
                    http.requestMatchers(HttpMethod.GET, "/typeProduct/*").authenticated();
                })
                .addFilterBefore(new JwtTokenValidator(jwtService), BasicAuthenticationFilter.class)
                .build();
    }
}
