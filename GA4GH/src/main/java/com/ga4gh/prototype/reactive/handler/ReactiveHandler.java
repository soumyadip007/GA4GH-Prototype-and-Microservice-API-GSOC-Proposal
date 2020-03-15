package com.ga4gh.prototype.reactive.handler;

import org.omg.CORBA.ServerRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class ReactiveHandler {

	public Mono<ServerResponse> flux(ServerRequest serverRequest){
		
	}
	
}
