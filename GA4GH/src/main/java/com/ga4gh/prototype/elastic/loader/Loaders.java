package com.ga4gh.prototype.elastic.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import com.ga4gh.prototype.service.GA4GHService;

@Component
public class Loaders {

	@Autowired
	private ElasticsearchOperations operations;
	

	@Autowired  
	private GA4GHService GA4GHService;
	
}
