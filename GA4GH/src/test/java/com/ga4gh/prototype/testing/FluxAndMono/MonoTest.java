package com.ga4gh.prototype.testing.FluxAndMono;

import org.junit.Test;

import reactor.core.publisher.Mono;

public class MonoTest {

	@Test
	public void monoTest()
	{
		Mono ga4ghMono=Mono.just("GA4GH");
	}
}
