package com.ga4gh.prototype.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages ="com.ga4gh.prototype.dao")
public class ElasticConfiguration {

}
