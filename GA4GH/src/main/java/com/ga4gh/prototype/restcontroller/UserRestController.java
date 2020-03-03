package com.ga4gh.prototype.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ga4gh.prototype.entity.GA4GH;
import com.ga4gh.prototype.service.GA4GHService;

@CrossOrigin(origins ="*",allowedHeaders="*",maxAge=200000) 
@RestController
@RequestMapping("/user")
public class UserRestController {

	
	private GA4GHService GA4GHService;
	

	@Autowired   
	public UserRestController(GA4GHService GA4GHService)
	{
		this.GA4GHService=GA4GHService;
	}
	
	

	@GetMapping("")
	public List<GA4GH> FindAll() {
	
		return GA4GHService.findAll();
	}
	
	
	@GetMapping("/id/{theId}")
	public GA4GH findById(@PathVariable int theId) {
		
		return GA4GHService.findById(theId);
	}
	
	@GetMapping("/sequencename/{theId}")
	public List<GA4GH> findBySequence_Name(@PathVariable String theId) {
		
		return GA4GHService.findBySequence_Name(theId);
	}

	@GetMapping("/genbank/{theId}")
	public List<GA4GH> findByGenBank_Accn(@PathVariable String theId) {
		
		return GA4GHService.findByGenBank_Accn(theId);
	}

	@GetMapping("/refseq/{theId}")
	public List<GA4GH> findByRefseq_Accn(@PathVariable String theId) {
		
		return GA4GHService.findByRefseq_Accn(theId);
	}
	
	@GetMapping("/sequencelength/{theId}")
	public List<GA4GH> findBySequencelength(@PathVariable String theId) {
		
		return GA4GHService.findBySequencelength(theId);
	}
	

}
