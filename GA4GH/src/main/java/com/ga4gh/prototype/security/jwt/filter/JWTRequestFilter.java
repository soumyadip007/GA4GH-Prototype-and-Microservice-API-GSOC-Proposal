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
		
		if(authizationHeader!=null && authizationHeader.startsWith("GA4GH")) {
			jwt=authizationHeader.substring(4);
			username=jwtutil.extractUsername(jwt);
		}
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails=this.myUserDetailsService.loadUserByUsername(username);
			
			if(jwtutil.validateToken(jwt, userDetails))
			{
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
