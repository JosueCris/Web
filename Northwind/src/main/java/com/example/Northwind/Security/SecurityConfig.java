package com.example.Northwind.Security;

import com.example.Northwind.Models.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authRequest -> authRequest
                        .requestMatchers(HttpMethod.POST, "/northwind/api/v1/authenticate").permitAll()
                        .requestMatchers(HttpMethod.GET, "/northwind/api/v1/public-access").permitAll()
                        .requestMatchers("/error").permitAll()

                        .requestMatchers(HttpMethod.POST, "/northwind/api/v1/products").hasAuthority(Permission.SAVE_ONE_PRODUCTS.name())
                        .requestMatchers(HttpMethod.GET, "/northwind/api/v1/products").hasAuthority(Permission.READ_ALL_PRODUCTS.name())

                        .anyRequest().denyAll())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }

}
