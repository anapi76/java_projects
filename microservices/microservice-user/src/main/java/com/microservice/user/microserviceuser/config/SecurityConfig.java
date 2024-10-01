package com.microservice.user.microserviceuser.config;

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

import com.microservice.user.microserviceuser.service.JwtService;
import com.microservice.user.microserviceuser.security.JwtTokenValidator;

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
                    http.requestMatchers(HttpMethod.GET, "/user").authenticated();
                    http.requestMatchers(HttpMethod.GET, "/user/*").authenticated();
                    http.requestMatchers(HttpMethod.POST, "/user/create").authenticated();
                    http.requestMatchers(HttpMethod.PUT, "/user/update/*").authenticated();
                    http.requestMatchers(HttpMethod.DELETE, "/user/delete/*").authenticated();
                    http.requestMatchers("/swagger-ui/**","/swagger-ui.html","/v3/api-docs/**").permitAll();
                    http.anyRequest().denyAll();
                })
                .addFilterBefore(new JwtTokenValidator(jwtService), BasicAuthenticationFilter.class)
                .build();
    }
}
