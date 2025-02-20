package com.amar.auth.basic;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//@Configuration
//@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// logger.debug("Using default configure(HttpSecurity). If subclassed this will
		// potentially override subclass configure(HttpSecurity).");

		http
		.csrf().disable() 
		.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll() //dont authenticate this request 
		.anyRequest().authenticated() //authenticate all the request 
		.and()
		//.formLogin().and()
		.httpBasic(); //with basic authentication
	}
}
