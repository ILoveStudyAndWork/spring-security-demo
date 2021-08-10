package com.example.springsecurity.springsecuritydemo.security;

import com.example.springsecurity.springsecuritydemo.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin")
                .hasRole("ADMIN")
                .anyRequest()
                .hasAnyRole("USER")
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard")
                .permitAll();


        // 如果不加and后面这一串的话，就会有一个死循环，
        // 要验证这个角色就必须登陆，而要登陆就需要看到login的页面，但是要看到登陆页面又必须有这个角色
        // 所以加了一个设置：login页面是大家都能看见的（permitAll）
    }
}
