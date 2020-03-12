package com.ga4gh.prototype.restcontroller;
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
	public String authenticate()
	{
		return "GA4GH";
	}
	
	
}
