package com.ga4gh.prototype.restcontroller;
import org.elasticsearch.client.security.AuthenticateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTRestController {

	@RequestMapping("/start")
	public String start()
	{
		return "GA4GH";
	}
	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity
		(@RequestBody AuthenticateRequest authenticateRequest) throws Exception
	{
		return "GA4GH";
	}
	
	
}
