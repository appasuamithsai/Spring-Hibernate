package com.amith.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder user=User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(user.username("Amith").password("amith@123").roles("Developer"))
                .withUser(user.username("Ajith").password("ajith@123").roles("HR"))
                .withUser(user.username("Charan").password("charan@123").roles("DBADMIN"));
    }


}
