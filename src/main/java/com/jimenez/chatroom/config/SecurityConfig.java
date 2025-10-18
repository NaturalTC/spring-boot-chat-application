package com.jimenez.chatroom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.socket.EnableWebSocketSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSocketSecurity
@Configuration
public class SecurityConfig {

    // Define the security filter chain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index.html", "/main.css", "/app.js", "/ws/**").permitAll() // public resources
                        .anyRequest().authenticated() // everything else needs auth
                )
                .formLogin(Customizer.withDefaults()) // default login page
                .logout(Customizer.withDefaults());

        return http.build();
    }
}