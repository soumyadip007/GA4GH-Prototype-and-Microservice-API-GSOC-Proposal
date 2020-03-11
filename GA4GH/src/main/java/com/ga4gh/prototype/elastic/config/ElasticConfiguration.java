package com.ga4gh.prototype.elastic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.elasticsearch.node.*;;
@Configuration
@EnableElasticsearchRepositories(basePackages ="com.ga4gh.prototype.dao")
public class ElasticConfiguration {


}
