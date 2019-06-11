
package com.cognizant.demo.EmployeeDemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration

@EnableWebSecurity
public class EmployeeSecurityConfiguration extends WebSecurityConfigurerAdapter {

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**");
//	}
	
	 private static final String[] AUTH_WHITELIST = {

	            // -- swagger ui
	            "/swagger-resources/**",
	            "/swagger-ui.html",
	            "/v2/api-docs",
	            "/webjars/**"
	    };
	    
	  
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll().anyRequest().authenticated().and().httpBasic();
		http.csrf().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.inMemoryAuthentication().withUser("admin").password("{noop}admin")
				.authorities("ROLE_ADMIN");
	}
}
