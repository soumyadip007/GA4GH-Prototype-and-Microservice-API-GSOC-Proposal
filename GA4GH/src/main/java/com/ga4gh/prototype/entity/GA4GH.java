package com.ga4gh.prototype.entity;


import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Getter;
import lombok.Setter;


@Getter	
@Setter	
@Entity
@Table(name = "ga4gh")
//@Document(indexName = "GA4GH", type="GA4GH", shards=1)
//@Document(indexName = "id", type = "GA4GH")
public class GA4GH {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;		


	@Column(name = "sequencename")
	private String sequencename;	
	
	@Column(name = "genbankaccn")
	private String genbankaccn;	
	
	@Column(name = "refseqaccn")
	private String refseqaccn;		
	

	@Column(name = "sequencelength")
	private String sequencelength;
}
