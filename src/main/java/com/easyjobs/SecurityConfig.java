package com.easyjobs;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@AllArgsConstructor

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();

        httpSecurity
                .authorizeRequests().antMatchers(HttpMethod.POST).permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.PUT).permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.DELETE).permitAll();


        httpSecurity.headers().frameOptions().disable();
    }
}


