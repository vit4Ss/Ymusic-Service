package com.example.ymusic.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 所有接口
                .allowedHeaders("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                //.allowedOrigins("*")
                .allowCredentials(true) // 是否支持跨域用户凭证
                .allowedOriginPatterns("*")// 支持
                .maxAge(3600);

//        registry.addMapping("/**")     //接口匹配
//                .allowCredentials(true)
//                .allowedOrigins("*")
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//                .allowedHeaders("*")
    }
}
