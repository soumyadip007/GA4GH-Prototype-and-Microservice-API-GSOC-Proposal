package com.ga4gh.prototype.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ga4gh.prototype.entity.GA4GH;
import com.ga4gh.prototype.repository.GA4GHPageRepository;
import com.ga4gh.prototype.repository.GA4GHRepository;

@Service
public class GA4GHService implements GA4GHServiceInterface {

	
	private GA4GHRepository GA4GHRepository;
	
	@Autowired
	private GA4GHPageRepository pg;

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
		
		GA4GHRepository.deleteById(theId);
	}

	public GA4GH findById(int theId) {
		
		return GA4GHRepository.findById(theId);
	}


	public List<GA4GH> findBySequence_Name(String seq) {
		
		return GA4GHRepository.findBySequencename(seq);
	}


	public List<GA4GH> findByGenBank_Accn(String seq) {
		
		return GA4GHRepository.findByGenbankaccn(seq);
	}


	public List<GA4GH> findByRefseq_Accn(String seq) {
		
		return GA4GHRepository.findByRefseqaccn(seq);
	}
	
	public List<GA4GH> findBySequencelength(String seq)
	{
		return GA4GHRepository.findBySequencelength(seq);
	}
	
	public List<GA4GH> findPage(Integer pageNo, Integer pageSize, String sortBy)
    {
        PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy) );
 
        Page<GA4GH> pagedResult = pg.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return null;
        }
    }
	

}
