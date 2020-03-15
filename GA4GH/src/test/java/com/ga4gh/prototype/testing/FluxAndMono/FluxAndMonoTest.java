package com.ga4gh.prototype.testing.FluxAndMono;

import org.junit.Test;

import reactor.core.publisher.Flux;

public class FluxAndMonoTest {

	
	@Test
	public void fluxTest()
	{
		Flux<String> ga4ghFlux=Flux.just("Spring Boot","Spring MVC", "GA4GH");
		
	}
}
