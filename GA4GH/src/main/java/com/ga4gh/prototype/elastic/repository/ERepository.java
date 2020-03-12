package com.ga4gh.prototype.elastic.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.ga4gh.prototype.entity.GA4GH;
@Repository("ERepository")
public interface ERepository extends ElasticsearchRepository<GA4GH, Integer> {
}