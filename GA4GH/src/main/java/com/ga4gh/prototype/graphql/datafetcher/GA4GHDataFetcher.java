package com.ga4gh.prototype.graphql.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ga4gh.prototype.entity.GA4GH;
import com.ga4gh.prototype.repository.GA4GHRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GA4GHDataFetcher implements DataFetcher {

	@Autowired
	GA4GHRepository ga4ghRepository;

	@Override
	public GA4GH get(DataFetchingEnvironment environment) {
		
		String key= environment.getArgument("id");
		int i=Integer.parseInt(key);
		return ga4ghRepository.findById(i);
	}

}
