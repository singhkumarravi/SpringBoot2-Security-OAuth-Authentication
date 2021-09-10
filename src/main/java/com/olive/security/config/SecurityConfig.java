package com.olive.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("SAM").password("{noop}SAM").authorities("ADMIN");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable()
	.authorizeRequests()
	.antMatchers("/home","/user","/login").permitAll()
    .anyRequest().authenticated()
    
    .and()
    .formLogin()
    .and()
    .oauth2Login();
    
	
	}

}
