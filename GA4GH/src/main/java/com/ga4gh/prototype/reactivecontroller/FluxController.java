package com.ga4gh.prototype.reactivecontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/flux")
public class FluxController {

	@GetMapping("/hello")
	public Flux<String> ga4ghFlux()
	{
		return Flux.just("GA4GH",
				"genbankaccn","refseqaccn","sequencelength")
				.log();
		
	}
}
