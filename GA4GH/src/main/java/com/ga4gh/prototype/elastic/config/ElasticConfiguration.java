package com.ga4gh.prototype.elastic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;;
@Configuration
@EnableJpaRepositories(basePackages ="com.ga4gh.prototype.repository")
@EnableElasticsearchRepositories(basePackages ="com.ga4gh.prototype.elastic.repository")
public class ElasticConfiguration {


}
