package com.ga4gh.prototype.testing.FluxAndMono;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxAndMonoTest {

	
	@Test
	public void fluxTest()
	{
		Flux<String> ga4ghFlux=Flux.just("GA4GH",
				"genbankaccn","refseqaccn","sequencelength","sequencename")
				.concatWith(Flux.error(new RuntimeException("Exception Occ")))
				.concatWith((Flux.just("After Error")))
				.log();
		
		
		ga4ghFlux
			.subscribe(System.out::println,
					(e)->System.err.println("Exception is "+e)
					,()->System.out.println("Completed"));
	}
	
	
	@Test
	public void fluxTesstElements_WithoutError() {
		
		Flux<String> ga4ghFlux=Flux.just("GA4GH",
				"genbankaccn","refseqaccn","sequencelength")
				.concatWith(Flux.error(new RuntimeException("Exception OfluxTesstElements_WithoutErrorcc()")))
				.log();
		
		StepVerifier.create(ga4ghFlux)
		.expectNext("GA4GH")
		.expectNext("genbankaccn")
		.expectNext("refseqaccn")
		.expectNext("sequencelength")
		.expectError(RuntimeException.class)
		//.expectErrorMessage("Exception OfluxTesstElements_WithoutErrorcc()")
		//.verifyComplete()
		.verify();  
		
	}
}
