package com.zo2ami.dto;

import java.io.Serializable;
import java.util.Date;

import com.zo2ami.entity.ServiceProviderUpdateProfileRequest;

public class ServiceProviderUpdateProfileRequestDTO implements Serializable {

	private static final long serialVersionUID = -649750859246145834L;
	
	private String mobileNumber;
	
	private String mobileNumber2;
	
	private String mobileNumber3;
	
	private Date dateOfBirth;
	
	private String brief;
	
	private String gender;
	
	private NationalityDTO nationality;
	
	private CountryDTO country;
	
	private ResidenceDTO areaOfResidence;
	
	
	
	
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMobileNumber2() {
		return mobileNumber2;
	}

	public void setMobileNumber2(String mobileNumber2) {
		this.mobileNumber2 = mobileNumber2;
	}

	public String getMobileNumber3() {
		return mobileNumber3;
	}

	public void setMobileNumber3(String mobileNumber3) {
		this.mobileNumber3 = mobileNumber3;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public NationalityDTO getNationality() {
		return nationality;
	}

	public void setNationality(NationalityDTO nationality) {
		this.nationality = nationality;
	}
	
	public CountryDTO getCountry() {
		return country;
	}

	public void setCountry(CountryDTO country) {
		this.country = country;
	}

	public ResidenceDTO getAreaOfResidence() {
		return areaOfResidence;
	}

	public void setAreaOfResidence(ResidenceDTO areaOfResidence) {
		this.areaOfResidence = areaOfResidence;
	}
	
	public ServiceProviderUpdateProfileRequestDTO toDto(
			ServiceProviderUpdateProfileRequest domain) {
		
		this.mobileNumber = domain.getMobileNumber();
		this.mobileNumber2 = domain.getMobileNumber2();
		this.mobileNumber3 = domain.getMobileNumber3();
		this.dateOfBirth = domain.getDateOfBirth();
		this.brief = domain.getBrief();
		if(domain.getCountry() != null)
			this.country = new CountryDTO().toDto(domain.getCountry());
		if(domain.getAreaOfResidence() != null)
			this.areaOfResidence = new ResidenceDTO().toDto(domain.getAreaOfResidence());
		if(domain.getNationality() != null)
			this.nationality = new NationalityDTO().toDto(domain.getNationality());
		if(domain.getGender() != null)
			this.gender = domain.getGender().toString();  
		
		
		return this;
	}
	
	
	

}
