package com.ga4gh.prototype.elastic.loader;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ga4gh.prototype.entity.GA4GH;
import com.ga4gh.prototype.repository.ERepository;
import com.ga4gh.prototype.service.GA4GHService;

@Component
public class Loaders {

	@Autowired
	private ElasticsearchOperations operations;
	
	@Autowired
	private ERepository eRepository;

	@Autowired  
	private GA4GHService GA4GHService;
	
	
	@PostConstruct
	@Transactional
	public void loadAll()
	{
		operations.putMapping(GA4GH.class);
		List<GA4GH> obj=GA4GHService.findAll();
		for(GA4GH o:obj)
			eRepository.save(o);
		
		System.out.print("Data loaded into elastic search");
	}
}
