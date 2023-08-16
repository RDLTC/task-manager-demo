package com.example.rudy.taskmanagerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration{
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth -> auth.requestMatchers(new AntPathRequestMatcher("/user/register")).permitAll()
                                                .anyRequest().authenticated()
        )
            .formLogin(form -> form.loginPage("/login")
                                .defaultSuccessUrl("/tasks")
                                .failureUrl("/login?error")
                                .permitAll()
            )
            .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                    .logoutSuccessUrl("/login?logout")
                                    .permitAll()
            );
        return http.build();
    }
    
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
