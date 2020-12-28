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
	
	@Column(name = "contact_person_email")
	private String contactPersonEmail ;
	
	@Column(name = "contact_person_mobile")
	private String contactPersonMobile ;
	
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
	
	public String getContactPersonEmail() {
		return contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	public String getContactPersonMobile() {
		return contactPersonMobile;
	}

	public void setContactPersonMobile(String contactPersonMobile) {
		this.contactPersonMobile = contactPersonMobile;
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
