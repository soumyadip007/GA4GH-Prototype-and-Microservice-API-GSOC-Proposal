package com.ga4gh.prototypel.security.jwt;

import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;

@Service 
public class JWTUtil {

	private String Secret_Key="secret";
	
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	
	public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
		
		final Claims claims=extractAllClaims(token);
		return claimsResolver.apply(claims);
		
	}
}
