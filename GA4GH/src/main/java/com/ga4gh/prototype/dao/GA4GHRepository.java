package com.ga4gh.prototype.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ga4gh.prototype.entity.GA4GH;


@Repository("GA4GHRepository")
public interface GA4GHRepository extends JpaRepository<GA4GH, Integer> {

	GA4GH findById(int id);
}
