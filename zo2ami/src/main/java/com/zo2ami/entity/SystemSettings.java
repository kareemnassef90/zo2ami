package com.zo2ami.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "system_settings")
public class SystemSettings implements Serializable {
	
	private static final long serialVersionUID = 1803354049217140920L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	private String filesUploadingPath;

	public String getFilesUploadingPath() {
		return filesUploadingPath;
	}

	public void setFilesUploadingPath(String filesUploadingPath) {
		this.filesUploadingPath = filesUploadingPath;
	}
	
	//mail settings goes here 
	
	

}
