//package com.tyrytyry.demo.Register;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//
//@Configuration
//public class SecurityConfig {
//
//    @Autowired
//    private DataSource dataSource;
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//
//        httpSecurity.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("users")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin() // tu ostatnio kończyłem
//                .loginPage("login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//        return httpSecurity.build();
//
//    }
//}