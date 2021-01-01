package com.zo2ami.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nationality")
public class Nationality implements Serializable {
	
	private static final long serialVersionUID = 1645581647417920942L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	@Column(name = "name_ar")
	private String nameAr;
	
	@Column(name = "name_en")
	private String nameEn;
	
	public Nationality() {}
	
	public Nationality(Long id) {
		this.id = id;
	}

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
