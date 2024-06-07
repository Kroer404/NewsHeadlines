package com.waylau.springboot.newsserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeHttpRequests->
                                authorizeHttpRequests
                                        .requestMatchers(allPassPath).permitAll()
                                        .anyRequest().authenticated()
                );

        http.formLogin(formLogin ->
                formLogin
                        //登录页面
                        .loginPage("/login").permitAll()
                        //登录处理接口
                        .loginProcessingUrl("/login")
                        //登录成功跳转
                        .defaultSuccessUrl("/index")
        );

        http.csrf(Customizer.withDefaults());

        http.logout(logout ->
                logout
                        .invalidateHttpSession(true));

        return http.build();
    }

    //放行接口
    String[] allPassPath = {"/login","/news","/news/**"};

    //用户权限允许访问的接口
    String[] userPassPath = {};

    //管理员权限允许访问的接口
    String[] adminPassPath = {};

}
