//package com.ga4gh.prototype.restcontroller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ga4gh.prototype.elastic.repository.ERepoImp;
//import com.ga4gh.prototype.entity.GA4GH;
//@CrossOrigin(origins ="*",allowedHeaders="*",maxAge=200000) 
//@RestController
//@RequestMapping("/elastic")
//public class ElasticRestController {
//
//	@Autowired  
//	private ERepoImp GA4GHService;
//	
//	@GetMapping("")
//	public List<GA4GH> FindAll() {
//	
//		return (List<GA4GH>) GA4GHService.getAllUsers();
//	}
//	
//	
////	@GetMapping("/id/{theId}")
////	public GA4GH findById(@PathVariable int theId) {
////		
////		return GA4GHService.findById(theId);
////	}
////	
////	@GetMapping("/sequencename/{theId}")
////	public List<GA4GH> findBySequence_Name(@PathVariable String theId) {
////		
////		return GA4GHService.findBySequencelength(theId);
////	}
//
//	
//	
//}
