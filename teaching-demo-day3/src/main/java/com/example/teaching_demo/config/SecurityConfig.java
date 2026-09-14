package com.example.teaching_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 1. Defining the filter logic
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // For teaching purposes, disable CSRF so Postman POST requests don't get secretly inexplicably blocked
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // .requestMatchers("/index.html", "/").permitAll() // TUTOR SABOTAGE: Leave this commented out so the UI gets brutally blocked by a 401! Uncomment live in class to fix the UI!
                .anyRequest().authenticated() // Explicitly block the API data behind a login
            )
            .httpBasic(withDefaults()); // Turn on simple browser popups and Postman Basic Auth headers

        return http.build();
    }

    // 2. Setting up our hardcoded "Database" of users exclusively for Day 3 Security testing
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("password123")
            .roles("ADMIN")
            .build();
        return new InMemoryUserDetailsManager(admin);
    }
}
