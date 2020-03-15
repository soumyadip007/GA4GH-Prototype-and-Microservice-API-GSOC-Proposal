package com.ga4gh.prototype.reactive.handler;

import org.omg.CORBA.ServerRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ReactiveHandler {

	public Mono<ServerResponse> flux(ServerRequest serverRequest){
		
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(
				Flux.just("GA4GH"," genbankaccn"," refseqaccn",
					" sequencelength").log(), String.class);
				
	}
	
}
