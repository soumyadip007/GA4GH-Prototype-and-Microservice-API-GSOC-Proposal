package com.ga4gh.prototype.elastic.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

@Component
public class Loaders {

	@Autowired
	ElasticsearchOperations operations;
	
}
