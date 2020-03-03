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
	
	@GetMapping("/sequence/{id}")
	public List<GA4GH> findBySequence_Name(@PathVariable String theId) {
		
		return GA4GHService.findBySequence_Name(theId);
	}

	@GetMapping("/id/genbank/{id}")
	public List<GA4GH> findByGenBank_Accn(@PathVariable String theId) {
		
		return GA4GHService.findByGenBank_Accn(theId);
	}

	@GetMapping("/id/refseq/{id}")
	public List<GA4GH> findByRefseq_Accn(@PathVariable String theId) {
		
		return GA4GHService.findByRefseq_Accn(theId);
	}
	
	

	@PostMapping("/add")
	public GA4GH add(@RequestBody GA4GH obj) {
		
		obj.setId(0);
		
		GA4GHService.save(obj);
		
		return obj;
	}
	
	@PostMapping("/update")
	public GA4GH update(@RequestBody GA4GH obj) {
		
		GA4GHService.save(obj);
		
		return obj;
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int theId) {
		
		 GA4GHService.deleteById(theId);
		 
		 return "value deleted";
	}
	
}
