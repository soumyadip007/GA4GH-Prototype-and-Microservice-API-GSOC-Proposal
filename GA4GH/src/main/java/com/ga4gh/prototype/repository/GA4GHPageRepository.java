package com.ga4gh.prototype.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ga4gh.prototype.entity.GA4GH;

@Repository
public interface GA4GHPageRepository extends PagingAndSortingRepository<GA4GH, Integer> {

}
