package com.ga4gh.prototype.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ga4gh.prototype.entity.GA4GH;
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
	
	

	@GetMapping("/")
	public List<GA4GH> FindAll() {
	
		return GA4GHService.findAll();
	}
	
	
	@GetMapping("/id/{id}")
	public GA4GH findById(@PathVariable int theId) {
		
		return GA4GHService.findById(theId);
	}
	

	public List<GA4GH> findBySequence_Name(String seq) {
		
		return GA4GHService.findBySequence_Name(seq);
	}


	public List<GA4GH> findByGenBank_Accn(String seq) {
		
		return GA4GHService.findByGenBank_Accn(seq);
	}


	public List<GA4GH> findByRefseq_Accn(String seq) {
		
		return GA4GHService.findByRefseq_Accn(seq);
	}
}
