package com.zo2ami.entity;

import java.io.Serializable;

import javax.persistence.Column;


public class Customer extends User implements Serializable{

	private static final long serialVersionUID = 447812873669851213L;

	@Column(name = "mobile_number_2")
	private String mobileNumber2 ;
	
	@Column(name = "mobile_number_3")
	private String mobileNumber3 ;
	
	@Column(name = "nationality_id")
	private Nationality nationality;
	
	@Column(name = "Country_id")
	private Country country;
	
	@Column(name = "area_of_residence_id")
	private Residence areaOfResidence;
	
	@Column(name = "brief" , length = 255 )
	private String brief;
	
	@Column(name = "profile_picture_path")
	private String profilePicturePath;

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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Residence getAreaOfResidence() {
		return areaOfResidence;
	}

	public void setAreaOfResidence(Residence areaOfResidence) {
		this.areaOfResidence = areaOfResidence;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getProfilePicturePath() {
		return profilePicturePath;
	}

	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}
	
	
	

}
