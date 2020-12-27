package com.zo2ami.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subscriber")
public class Subscriber extends Customer implements Serializable {

	private static final long serialVersionUID = -2144357494903655L;
	
	@Column(name = "certificate_path")
	private String certificatePath;
	
	

	public String getCertificatePath() {
		return certificatePath;
	}

	public void setCertificatePath(String certificatePath) {
		this.certificatePath = certificatePath;
	}
	
	//private Billing Details
	
	
	
	

}
