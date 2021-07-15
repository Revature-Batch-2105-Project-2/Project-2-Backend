package com.revature.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.revature.services.EmployeeService;
import com.revature.util.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	private EmployeeService es;
	private JwtRequestFilter filter;
	
	@Autowired
	public SecurityConfigurer(EmployeeService es, JwtRequestFilter filter) {
		this.es = es;
		this.filter = filter;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.es);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// tells Spring Security to allow requests to "/log_in" to go through without authentication, but require all other endpoints to have been authenticated
		http.csrf().disable().authorizeRequests().antMatchers("/employees/log_in").permitAll().anyRequest().authenticated()
		.and()
		.logout().deleteCookies("remove").invalidateHttpSession(false).logoutUrl("/employees/log_out")/*.logoutSuccessUrl("/logout-success")*/
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.cors();
		http.addFilterBefore(this.filter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
