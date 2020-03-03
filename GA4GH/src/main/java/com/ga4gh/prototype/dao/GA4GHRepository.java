package com.ga4gh.prototype.dao;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GA4GHRepository extends JpaRepository<Ga4GH, Integer> {

	Ga4GH findById(int id);
}
