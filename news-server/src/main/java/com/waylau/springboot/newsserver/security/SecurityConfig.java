package com.waylau.springboot.newsserver.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeHttpRequests->
                                authorizeHttpRequests
                                        .requestMatchers(allPassPath).permitAll()
                                        .requestMatchers(userPassPath).hasAnyRole("USER")
                                        .requestMatchers(adminPassPath).hasAnyRole("ADMIN")
                                        .anyRequest().authenticated()
                );

        http.formLogin(formLogin ->
                formLogin
                        //登录处理接口
                        .loginProcessingUrl("/login")
                        .successHandler(new AuthenticationSuccessHandler() {
                            @Override
                            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                                response.setContentType("application/json;charset=utf-8");
                                response.getWriter().write("loginSuccess");
                            }
                        })
                        .failureHandler(new AuthenticationFailureHandler() {
                            @Override
                            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                                response.setContentType("application/json;charset=utf-8");
                                response.getWriter().write("loginError");
                                System.out.println("登录失败信息");
                                exception.printStackTrace();
                            }
                        })
        );

        http.csrf(Customizer.withDefaults());

        http.cors(Customizer.withDefaults());

//        http.logout(logout ->
//                logout
//                        .invalidateHttpSession(true));

        return http.build();
    }

    //放行接口
    String[] allPassPath = {"/login","/news","/news/**"};

    //用户权限允许访问的接口
    String[] userPassPath = {};

    //管理员权限允许访问的接口
    String[] adminPassPath = {};

}
