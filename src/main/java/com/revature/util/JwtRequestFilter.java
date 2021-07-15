package com.revature.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.revature.services.EmployeeService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	private EmployeeService es;
	private JwtUtil jwt;
	
	@Autowired
	public JwtRequestFilter(EmployeeService es, JwtUtil jwt) {
		this.es = es;
		this.jwt = jwt;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		final String token = request.getHeader("Authorization");
		String username = null;
		
		if (token != null) {
			username = this.jwt.decodeToken(token).getIssuer();
		}
		
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails details = this.es.loadUserByUsername(username);
			if (this.jwt.verifyToken(token, details)) {
				UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
				upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(upat);
			}
		}
		
		filterChain.doFilter(request, response);
	}
}
