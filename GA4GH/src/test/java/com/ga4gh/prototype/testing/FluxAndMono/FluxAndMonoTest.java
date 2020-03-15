package com.ga4gh.prototype.testing.FluxAndMono;

import org.junit.Test;

import reactor.core.publisher.Flux;

public class FluxAndMonoTest {

	
	@Test
	public void fluxTest()
	{
		Flux<String> ga4ghFlux=Flux.just("GA4GH",
				"genbankaccn","refseqaccn","sequencelength","sequencename")
				.concatWith(Flux.error(new RuntimeException("Exception Occ")))
				.log();
		
		
		ga4ghFlux
			.subscribe(System.out::println,
					(e)->System.err.println(e)
					);
	}
}
