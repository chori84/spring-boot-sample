package com.chori.springbootsecurity;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                .requestMatchers(new AntPathRequestMatcher("/**/*.html")).permitAll()
                .antMatchers("/**/*.html").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin().permitAll()
//                .formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
                .and()
                .logout().permitAll();
    }
}
