package com.zo2ami.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "service_provider")
public class ServiceProvider extends Customer implements Serializable {

	private static final long serialVersionUID = 5789694737150372007L;
	
	@Column(name = "contact_person_name")
	private String contactPersonName ; 
	
	@Column(name = "legal_document_path")
	private String legalDocumentPath;
	
	@Column(name = "location")
	private String location;

	
	
	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getLegalDocumentPath() {
		return legalDocumentPath;
	}

	public void setLegalDocumentPath(String legalDocumentPath) {
		this.legalDocumentPath = legalDocumentPath;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	

}
