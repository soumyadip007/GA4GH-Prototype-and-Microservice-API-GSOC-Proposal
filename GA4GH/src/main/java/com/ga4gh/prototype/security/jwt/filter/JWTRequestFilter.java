package com.ga4gh.prototype.security.jwt.filter;

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

import com.ga4gh.prototype.security.MyUserDetailsService;
import com.ga4gh.prototype.security.jwt.JWTUtil;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Component
public class JWTRequestFilter extends OncePerRequestFilter {

	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Autowired
	JWTUtil jwtutil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String authizationHeader=request.getHeader("Authorization");
		
		System.out.println("AuthizationHeader->"+authizationHeader);
		
		String username=null;
		String jwt=null;
		
		if(authizationHeader!=null && authizationHeader.startsWith("Bearer")) {
			jwt=authizationHeader.substring(7);
			username=jwtutil.extractUsername(jwt);
			
			System.out.println("JWT->"+jwt);
			System.out.println("Username->"+username);
		}
		
		System.out.println("doFilterInternal");
		System.out.println("doFilterInternal");
		
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			
			UserDetails userDetails=this.myUserDetailsService.loadUserByUsername(username);
			
			System.out.println("Token is Before Valid");
			System.out.println("Token is Before Valid");
			if(jwtutil.validateToken(jwt, userDetails))
			{
				System.out.println("Token is Valid");
				System.out.println("Token is Valid");
				System.out.println("Token is Valid");
				System.out.println("Token is Valid");
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource()
						.buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request,response);
	}

}
