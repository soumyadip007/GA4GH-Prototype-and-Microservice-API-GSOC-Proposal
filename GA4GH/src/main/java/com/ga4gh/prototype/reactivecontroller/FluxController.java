package com.ga4gh.prototype.reactivecontroller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class FluxController {

	@GetMapping("/flux")
	public Flux<String> ga4ghFlux()
	{
		return Flux.just("GA4GH",
				" genbankaccn"," refseqaccn"," sequencelength")
				.delayElements(Duration.ofSeconds(1))
				.log();
		
	}
	
	@GetMapping(value="/fluxstream", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<String> ga4ghFluxStream()
	{
		return Flux.just("GA4GH",
				" genbankaccn"," refseqaccn"," sequencelength")
				.delayElements(Duration.ofSeconds(1))
				.log();
		
	}
}
