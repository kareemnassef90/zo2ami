package com.zo2ami.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zo2ami.enums.MailTemplateCode;

@Entity
@Table(name = "mail_template")
public class MailTemplate {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	@Column(name = "mail_from")
	private String mailFrom;
	
	@Column(name = "mail_cc")
	private String mailCc;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "body")
	private String body;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "code")
	private MailTemplateCode code; 
	
	
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getMailCc() {
		return mailCc;
	}

	public void setMailCc(String mailCc) {
		this.mailCc = mailCc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public MailTemplateCode getCode() {
		return code;
	}

	public void setCode(MailTemplateCode code) {
		this.code = code;
	}
	
	
	
	

}
