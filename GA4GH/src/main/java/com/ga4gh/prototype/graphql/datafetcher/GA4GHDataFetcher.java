package com.ga4gh.prototype.graphql.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;

import com.ga4gh.prototype.entity.GA4GH;
import com.ga4gh.prototype.repository.GA4GHRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

public class GA4GHDataFetcher implements DataFetcher {

	@Autowired
	GA4GHRepository ga4ghRepository;

	@Override
	public GA4GH get(DataFetchingEnvironment environment) {
		
		int key= environment.getArgument("id");
		
		return ga4ghRepository.findById(key);
	}

}
