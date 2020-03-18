package com.ga4gh.prototype.graphql.service;


import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.ga4gh.prototype.graphql.datafetcher.AllGA4GHDataFetcher;
import com.ga4gh.prototype.graphql.datafetcher.GA4GHDataFetcher;
import com.ga4gh.prototype.repository.GA4GHRepository;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.errors.SchemaProblem;

@Service
public class GraphQLService {

	@Autowired
	GA4GHRepository ga4ghRepository;
	
	@Value("classpath:ga4gh.graphql")
	Resource resource;
	
	@Autowired
	private AllGA4GHDataFetcher allGA4GHDataFetcher;
	
//	@Autowired
//	private GA4GHDataFetcher ga4ghDataFetcher;
	
	private GraphQL graphQL;
	
	@PostConstruct
	private void loadSchema() throws IOException,SchemaProblem {
		
		
		File schemaFile=resource.getFile();
		  
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
	    RuntimeWiring wiring = buildRuntimeWiring();
	    GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
	    graphQL = GraphQL.newGraphQL(schema).build();
		
	}

	 private RuntimeWiring buildRuntimeWiring() {
	        return RuntimeWiring.newRuntimeWiring()
	                .type("Query", typeWiring -> typeWiring
	                        .dataFetcher("allData", allGA4GHDataFetcher))
	                        //.dataFetcher("ga4gh", ga4ghDataFetcher))
	                .build();
	    }
	
    public GraphQL getGraphQL() {
        return graphQL;
    }
	
}
