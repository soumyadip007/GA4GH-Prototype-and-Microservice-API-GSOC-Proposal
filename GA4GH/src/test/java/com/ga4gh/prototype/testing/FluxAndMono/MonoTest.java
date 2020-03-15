package com.ga4gh.prototype.testing.FluxAndMono;

import javax.management.RuntimeErrorException;

import org.junit.Test;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class MonoTest {

	@Test
	public void monoTest()
	{
		Mono ga4ghMono=Mono.just("GA4GH")
				.log();
		
		StepVerifier.create(ga4ghMono)
		.expectNext("GA4GH")
		.verifyComplete();
	}
	
	@Test
	public void monoError()
	{
		
		StepVerifier.create(Mono.error(new RuntimeErrorException(null,"Exception in mono")).log())
		.expectError(RuntimeException.class)
		.verify();
	}
}
