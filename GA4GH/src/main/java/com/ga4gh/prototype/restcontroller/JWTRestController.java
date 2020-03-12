package com.ga4gh.prototype.restcontroller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTRestController {

	@RequestMapping("/start")
	public String start()
	{
		return "GA4GH";
	}
	
	
	
}
