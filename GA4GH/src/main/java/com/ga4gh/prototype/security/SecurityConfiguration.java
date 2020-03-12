package com.ga4gh.prototype.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
			.authorizeRequests().antMatchers("/authenticate").permitAll()
			.anyRequest().authenticated();
//			.and().sessionManagement().
//			sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	@Override
	@Bean
	public AuthenticationManager authenticationManager() throws Exception{
		return super.authenticationManagerBean();
	}
	
}