package com.example.Northwind.Security;

//import com.example.Northwind.ImpServices.IUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth ->
                    auth.requestMatchers("http://localhost:8080/northwind/api/v1/employees/get/all").permitAll())
//                        .requestMatchers("/publico/**").permitAll()
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .anyRequest().authenticated()
                .formLogin(form -> form.permitAll())
//                .formLogin(Customizer.withDefaults()
                .sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                            .invalidSessionUrl("/login")
                            .maximumSessions(1).expiredUrl("/login").sessionRegistry(sessionRegistry());
                    session.sessionFixation().migrateSession();
                })
                .build();

//        http
//                .httpBasic(Customizer.withDefaults()
//                );
//        return http.build();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    public AuthenticationSuccessHandler successHandler() {
        return (((request, response, authentication) ->
                response.sendRedirect("/localhost:8080")
        ));
    }

//    @Bean
//    public IUserDetailsService userDetailService() {
//        return new IUserDetailsService();
//    }
//
//    @Bean
//    public PasswordEncoder passEnconder() {
//        return new BCryptPasswordEncoder();
//    }
}