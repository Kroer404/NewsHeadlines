package com.waylau.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        //所有请求都不要认证，未实现
                        .requestMatchers("/**").permitAll()
                        //所有请求都需要认证
                        .anyRequest().authenticated()
                )
                //启用http基本身份验证
                .httpBasic(withDefaults());
        http
                //禁用csrf
                .csrf(csrf -> csrf.disable());
        return http.build();
    }


    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();
        users
                //创建用户user1，密码password1，角色类型USER
                .createUser(User.withUsername("user1")
                        .password("{noop}password1")
                        .authorities("USER").build());
        return users;
    }

}
