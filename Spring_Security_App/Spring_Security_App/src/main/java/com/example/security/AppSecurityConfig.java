package com.example.security;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUsers(){
        UserDetails u1 = User.withDefaultPasswordEncoder()
                .username("raj")
                .password("raj@1")
                .build();

        UserDetails u2 = User.withDefaultPasswordEncoder()
                .username("john")
                .password("john@1")
                .build();

        UserDetails u3 = User.withDefaultPasswordEncoder()
                .username("steve")
                .password("steve@1")
                .build();

        return new InMemoryUserDetailsManager(u1,u2,u3);

    }

    @Bean
    @SneakyThrows
     public SecurityFilterChain security(HttpSecurity http){

        http.authorizeHttpRequests((req) -> {

                    req.requestMatchers("/contact")
                            .permitAll()
                            .anyRequest()
                            .authenticated();
                }) .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
        return http.build();

}

}
