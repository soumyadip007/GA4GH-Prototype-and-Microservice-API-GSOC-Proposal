package com.ga4gh.prototype.graphql.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ga4gh.prototype.entity.GA4GH;
import com.ga4gh.prototype.repository.GA4GHRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllGA4GHDataFetcher implements DataFetcher {

	@Autowired
	GA4GHRepository ga4ghRepository;

	@Override
	public List<GA4GH> get(DataFetchingEnvironment environment) {
		
		return ga4ghRepository.findAll();
	}
	
	
}
