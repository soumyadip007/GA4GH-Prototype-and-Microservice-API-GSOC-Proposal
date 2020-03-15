package com.ga4gh.prototype.reactive.controller;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ga4gh.prototype.entity.GA4GH;
import com.ga4gh.prototype.service.GA4GHService;

import reactor.core.publisher.Flux;

@RestController
public class FluxController {

//	@Autowired  
//	private GA4GHService GA4GHService;

	@GetMapping("/flux")
	public Flux<String> ga4ghFlux()
	{
		return Flux.just("GA4GH",
				" genbankaccn"," refseqaccn"," sequencelength")
				.delayElements(Duration.ofSeconds(1))
				.log();
		
	}
	
	@GetMapping(value="/stream", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<String> ga4ghFluxStream()
	{
		return Flux.just("GA4GH",
				" genbankaccn"," refseqaccn"," sequencelength")
				.delayElements(Duration.ofSeconds(1))
				.log();
		
	}
	
	
//	@GetMapping(value="/GA4GH", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Flux<List<GA4GH>> ga4ghFluxaLL()
//	{
//		List<GA4GH> ls=GA4GHService.findAll();
//		return Flux.just(ls)
//				.delayElements(Duration.ofSeconds(1))
//				.log();
//		
//	}
}
