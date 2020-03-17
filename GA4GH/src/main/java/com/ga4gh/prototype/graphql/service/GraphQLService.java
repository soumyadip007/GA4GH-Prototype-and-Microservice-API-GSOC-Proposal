package com.ga4gh.prototype.graphql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ga4gh.prototype.repository.GA4GHRepository;

@Service
public class GraphQLService {

	@Autowired
	GA4GHRepository ga4ghRepository;
}
