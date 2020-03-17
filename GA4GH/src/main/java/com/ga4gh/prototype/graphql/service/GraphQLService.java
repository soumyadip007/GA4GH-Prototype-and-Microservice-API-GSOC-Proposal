package com.ga4gh.prototype.graphql.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ga4gh.prototype.graphql.datafetcher.AllGA4GHDataFetcher;
import com.ga4gh.prototype.graphql.datafetcher.GA4GHDataFetcher;
import com.ga4gh.prototype.repository.GA4GHRepository;

import graphql.GraphQL;

@Service
public class GraphQLService {

	@Autowired
	GA4GHRepository ga4ghRepository;
	
	@Value("classpath:ga4gh.graphql")
	Resource resource;
	
	@Autowired
	private AllGA4GHDataFetcher allGA4GHDataFetcher;
	
	@Autowired
	private GA4GHDataFetcher ga4ghDataFetcher;
	
	private GraphQL graphQL;
	
	
	
}
