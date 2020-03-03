package com.ga4gh.prototype.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter	
@Setter	
@Entity
@Table(name = "ga4gh")
public class GA4GH {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int id;		


	@Column(name = "Sequence_Name")
	String Sequence_Name;	
	
	@Column(name = "GenBank_Accn")
	String GenBank_Accn;	
	
	@Column(name = "Refseq_Accn")
	String Refseq_Accn;		
}
