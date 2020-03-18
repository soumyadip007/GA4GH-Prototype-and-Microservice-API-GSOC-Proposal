package com.ga4gh.prototype.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter	
@Setter	
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ga4gh")
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
