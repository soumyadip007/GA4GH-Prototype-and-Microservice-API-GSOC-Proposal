package com.ga4gh.prototype.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ga4gh.prototype.dao.GA4GHRepository;
import com.ga4gh.prototype.entity.GA4GH;

@Service
public class GA4GHService implements GA4GHServiceInterface {

	
	private GA4GHRepository GA4GHRepository;
	

	@Autowired   
	public GA4GHService(GA4GHRepository GA4GHRepository)
	{
		this.GA4GHRepository=GA4GHRepository;
	}
	
	
	public List<GA4GH> findAll() {
		return GA4GHRepository.findAll();
	}

	public void save(GA4GH OBJ) {
		
		GA4GHRepository.save(OBJ);
	}

	public void deleteById(int theId) {
		
	}

	public GA4GH findById(int theId) {
		
		return null;
	}

}
