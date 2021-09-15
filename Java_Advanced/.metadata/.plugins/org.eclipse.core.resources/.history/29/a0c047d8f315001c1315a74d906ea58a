package com.vti.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.vti.service.IAccountService;

@Component
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	@Autowired
	IAccountService accountService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(accountService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.cors()
//		.and()
//		.authorizeRequests()
//		.antMatchers("/api/v1/accounts", "api/v1/departments/*" ,"/api/v1/registratiton").hasAnyAuthority("Admin", "Manager")
//		.anyRequest().authenticated()
//		.and()
//		.httpBasic()
//		.and()
//		.csrf().disable();
//	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.cors()
		.and()
		.authorizeRequests()
		.antMatchers("/api/v1/accounts", "api/v1/departments/*" ,"/api/v1/registratiton")
		.authenticated()
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.anyRequest().permitAll()
//			.and()
//			.httpBasic()
//			.and()
//			.csrf().disable();
//	}
}
