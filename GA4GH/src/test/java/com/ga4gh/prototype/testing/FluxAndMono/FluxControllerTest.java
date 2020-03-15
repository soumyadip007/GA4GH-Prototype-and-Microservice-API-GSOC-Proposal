package com.ga4gh.prototype.testing.FluxAndMono;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@WebFluxTest(controllers = FluxControllerTest.class)
public class FluxControllerTest {

	@Autowired
	WebTestClient webTestClient;
	
	
	@Test
	public void flux_approch1() {
		
		Flux<String> responseBody = webTestClient.get().uri("/flux/stream")
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.returnResult(String.class)
		.getResponseBody();
		
		StepVerifier.create(responseBody)
		.expectSubscription()
		.expectNext("GA4GH")
		.expectNext("genbankaccn")
		.expectNext("refseqaccn")
		.expectNext("sequencelength")
		.verifyComplete();  
		
	}
}
