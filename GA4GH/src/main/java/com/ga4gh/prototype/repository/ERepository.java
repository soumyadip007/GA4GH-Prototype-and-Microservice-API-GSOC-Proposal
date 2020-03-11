package com.ga4gh.prototype.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.ga4gh.prototype.entity.GA4GH;

@Repository("ERepository")
public interface ERepository extends ElasticsearchRepository<GA4GH, Integer> {

	public GA4GH findById(int id);
	
	public List<GA4GH> findBySequencename(String seq);
	
	public List<GA4GH> findByGenbankaccn(String seq);
	
	public List<GA4GH> findByRefseqaccn(String seq);
	
	public List<GA4GH> findBySequencelength(String seq);
}
