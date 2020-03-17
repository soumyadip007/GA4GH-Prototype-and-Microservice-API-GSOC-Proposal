package com.ga4gh.prototype.graphql.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ga4gh.prototype.entity.GA4GH;
import com.ga4gh.prototype.repository.GA4GHRepository;

import graphql.schema.DataFetcher;

@Component
public class AllGA4GHDataFetcher implements DataFetcher<List<GA4GH>> {

	@Autowired
	GA4GHRepository ga4ghRepository;
}
