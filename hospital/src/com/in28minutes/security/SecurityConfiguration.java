package com.in28minutes.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// @Autowired
	// public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
	// throws Exception {
	// auth.inMemoryAuthentication().withUser("in28Minutes").password("dummy")
	// .roles("USER", "ADMIN");
	// }
	//
	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.authorizeRequests().antMatchers("/login").permitAll()
	// .antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
	// .formLogin().and().exceptionHandling()
	// .accessDeniedPage("/access-denied");
	// }

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password, enabled from tbl_users where username=?")
				.authoritiesByUsernameQuery("select username, authority from tbl_authorities where username=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/hello").access("hasRole('ROLE_ADMIN')").anyRequest().permitAll().and()
				.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").and()
				.logout().logoutSuccessUrl("/login?logout").and().exceptionHandling().accessDeniedPage("/403").and()
				.csrf();
	}

}