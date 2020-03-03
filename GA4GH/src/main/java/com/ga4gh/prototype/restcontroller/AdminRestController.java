package com.ga4gh.prototype.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ga4gh.prototype.dao.GA4GHRepository;
import com.ga4gh.prototype.service.GA4GHService;

@CrossOrigin(origins ="*",allowedHeaders="*",maxAge=200000) 
@RestController
@RequestMapping("/admin")
public class AdminRestController {

	
	private GA4GHService GA4GHService;
	

	@Autowired   
	public AdminRestController(GA4GHService GA4GHService)
	{
		this.GA4GHService=GA4GHService;
	}
	
}
