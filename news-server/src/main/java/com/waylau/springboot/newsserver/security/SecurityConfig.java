package com.waylau.springboot.newsserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        //所有请求都不要认证
                        //问题：现在仅允许访问admins/hi（无论是否登录），但是访问其他路径时会报错403
                        //新问题:无法访问/login
                        .requestMatchers(passPath).permitAll()
                        //余下所有请求都需要认证
                        .anyRequest().authenticated()

                );
                //手动定义login页面
                //.formLogin(form -> form
                //.loginPage("/login")
                //);

                //启用http基本身份验证,启用后似乎会拦截所有请求，所以默认禁用
                //.httpBasic(Customizer.withDefaults());
        http
                //禁用csrf
                .csrf(csrf -> csrf.disable());
        return http.build();
    }

    //不需要认证放行的路径
    //问题：通配符似乎识别异常，“*” 只能严格匹配一个字符
    String[] passPath = {"/admins/hi","/news/**","/news/*"};


    //用户信息服务
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
