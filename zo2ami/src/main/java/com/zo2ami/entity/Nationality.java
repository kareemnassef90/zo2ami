package com.zo2ami.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nationality")
public class Nationality {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	@Column(name = "name_ar")
	private String nameAr;
	
	@Column(name = "name_en")
	private String nameEn;
	
	

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
	
	
	

}
