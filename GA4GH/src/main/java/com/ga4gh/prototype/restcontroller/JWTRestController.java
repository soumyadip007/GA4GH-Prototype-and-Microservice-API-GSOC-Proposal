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
	
	@RequestMapping(value="/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken
				(@RequestBody AuthenticationRequest authenticateRequest) throws Exception
	{

		System.out.println(authenticateRequest.getUsername());
		System.out.println(authenticateRequest.getUsername());
		System.out.println(authenticateRequest.getPassword());
		
		try {
			
			System.out.println("With in TRY");
			
			UsernamePasswordAuthenticationToken obj=new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), 
					authenticateRequest.getPassword());
			
			System.out.println(obj.toString());
			
			authenticationManager.authenticate(obj);
		}
		catch (BadCredentialsException e) {
			//	throw new Exception("Bad Credentioals");
				
				e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			//	e.printStackTrace();
			}
		System.out.println("After Catch");
	
		final UserDetails userDetails=myUserDetailsService
				.loadUserByUsername(authenticateRequest.getUsername());
	
		final String jwt=jwtutil.generateToken(userDetails);
	
		
		return  ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	
}
