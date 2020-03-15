package com.ga4gh.prototypr.reactivecontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class FluxController {

	@GetMapping("/flux")
	public Flux<String> ga4ghFlux()
	{
		return Flux.just("GA4GH",
				"genbankaccn","refseqaccn","sequencelength")
				.log();
		
	}
}
