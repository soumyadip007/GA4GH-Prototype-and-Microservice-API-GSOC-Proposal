package com.ga4gh.prototype.security.jwt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ga4gh.prototype.security.MyUserDetailsService;
import com.ga4gh.prototype.security.jwt.JWTUtil;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
public class JWTRequestFilter extends OncePerRequestFilter {

	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Autowired
	JWTUtil jwtutil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String authizationHeader=request.getHeader("Authorization");
		
		String username=null;
		String jwt=null;
		
		if(authizationHeader!=null && authizationHeader.startsWith("JWT")) {
			jwt=authizationHeader.substring(4);
			username=jwtutil.extractUsername(jwt);
		}
		
	}

}
