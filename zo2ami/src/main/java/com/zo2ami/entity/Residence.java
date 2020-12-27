package com.zo2ami.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "residence")
public class Residence implements Serializable{

	private static final long serialVersionUID = -1316474380502928807L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	@Column(name = "name_ar")
	private String nameAr ;
	
	@Column(name = "name_en")
	private String nameEn ;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country ;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameAr() {
		return nameAr;
	}

	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	

}
