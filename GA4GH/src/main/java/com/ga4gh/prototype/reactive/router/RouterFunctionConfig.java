package com.ga4gh.prototype.reactive.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.ga4gh.prototype.reactive.handler.GA4GHReactiveHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;


@Configuration
public class RouterFunctionConfig {
	
	@Bean
	public RouterFunction<ServerResponse> route(GA4GHReactiveHandler reactiveHandler)
	{
		return RouterFunctions
			.route(GET("/functional/flux")
					.and(accept(MediaType.APPLICATION_JSON))
							,reactiveHandler::flux)
			.andRoute(GET("/functional/flux")
					.and(accept(MediaType.APPLICATION_JSON))
							,reactiveHandler::mono);
	
	}

}
