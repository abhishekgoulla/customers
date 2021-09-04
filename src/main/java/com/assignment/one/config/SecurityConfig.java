package com.assignment.one.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.assignment.one.service.MyUserDetailsService;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private MyUserDetailsService userDetailsService;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
auth.userDetailsService(userDetailsService);
		// auth.inMemoryAuthentication()
//		.withUser("admin")
//		.password("Admin123$")
//		.roles("ADMIN")
//		.and()
//		.withUser("test")
//		.password("test123$")
//		.roles("USER");
	}
	

//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		// TODO Auto-generated method stub
//		return super.authenticationManagerBean();
//	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.csrf().disable()
		.authorizeRequests().antMatchers("/").hasAuthority("ADMIN")
		.antMatchers("/Customers").hasAuthority("USER")
				.antMatchers("/**").permitAll()
				.and().formLogin();
	}

	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
