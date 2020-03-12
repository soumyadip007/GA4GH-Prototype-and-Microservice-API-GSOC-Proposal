package com.ga4gh.prototypel.security.jwt;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;

@Service 
public class JWTUtil {

	private String Secret_Key="secret";
	
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExperiation);
	}
	
	
}
