package com.example.ymusic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig  {
    //权限隔离
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
//        return http.
//    }
      @Bean
      public PasswordEncoder passwordEncoder(){
          return new BCryptPasswordEncoder();
      }
}
