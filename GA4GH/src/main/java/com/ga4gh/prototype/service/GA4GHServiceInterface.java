package com.ga4gh.prototype.service;

import java.util.List;

import com.ga4gh.prototype.entity.GA4GH;

public interface GA4GHServiceInterface {

	public List<GA4GH> findAll();

	public void save(GA4GH OBJ);
	
	public void deleteById(int theId);
	
	public GA4GH findById(int theId);
//
//	public List<GA4GH> findBySequence_Name(String seq);
//	
//	public List<GA4GH> findByGenBank_Accn(String seq);
//	
//	public List<GA4GH> findByRefseq_Accn(String seq);
}
