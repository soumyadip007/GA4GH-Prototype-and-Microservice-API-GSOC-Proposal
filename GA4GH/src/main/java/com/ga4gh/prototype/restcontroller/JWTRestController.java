package com.ga4gh.prototype.restcontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ga4gh.prototype.security.models.AuthenticationRequest;

@RestController
public class JWTRestController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@RequestMapping("/start")
	public String start()
	{
		return "GA4GH";
	}
	
	public ResponseEntity<?> createAuthenticationToken
	(@RequestBody AuthenticationRequest authenticateRequest) throws Exception
	{

		authenticationManager.authenticate(	
				new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), 
						authenticateRequest.getPassword()));
		return null;
	}

	
}
