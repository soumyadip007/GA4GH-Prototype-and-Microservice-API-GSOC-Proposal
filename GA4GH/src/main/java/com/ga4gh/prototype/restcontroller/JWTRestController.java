package com.ga4gh.prototype.restcontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ga4gh.prototype.security.MyUserDetailsService;
import com.ga4gh.prototype.security.jwt.JWTUtil;
import com.ga4gh.prototype.security.models.AuthenticationRequest;
import com.ga4gh.prototype.security.models.AuthenticationResponse;

@RestController
public class JWTRestController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Autowired
	JWTUtil jwtutil;
	
	@RequestMapping("/start")
	public String start()
	{
		return "GA4GH";
	}
	
	@RequestMapping(value="/authinticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken
	(@RequestBody AuthenticationRequest authenticateRequest) throws Exception
	{

		try {
		authenticationManager.authenticate(	
				new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), 
						authenticateRequest.getPassword()));
		}
		catch (BadCredentialsException e) {
			throw new Exception("Bad Credentioals");
		}
		
		final UserDetails userDetails=myUserDetailsService
				.loadUserByUsername(authenticateRequest.getUsername());
		
		
		final String jwt=jwtutil.generateToken(userDetails);
	
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	
}
