package com.zo2ami.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zo2ami.entity.Customer;
import com.zo2ami.entity.Permission;
import com.zo2ami.entity.Role;
import com.zo2ami.entity.Subscriber;
import com.zo2ami.enums.Gender;

public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = 6445731753329096797L;

	private long id;

	private String username;

	private String email;

	private String password;

	private String mobileNumber;

	private String mobileNumber2;

	private String mobileNumber3;

	private Date dateOfBirth;

	private String gender;

	private boolean isDeleted;

	private boolean enabled;

	private Date creationDate;

	private List<RoleDTO> roles = new ArrayList<>();

	private NationalityDTO nationality;

	private CountryDTO country;

	private ResidenceDTO areaOfResidence;

	private String brief;
	
	private String accountType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public List<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public CustomerDTO toDto(Customer domain) {
		this.id = domain.getId();
		this.username = domain.getUsername();
		this.email = domain.getEmail();
		this.mobileNumber = domain.getMobileNumber();
		this.mobileNumber2 = domain.getMobileNumber2();
		this.mobileNumber3 = domain.getMobileNumber3();
		this.dateOfBirth = domain.getDateOfBirth();
		this.brief = domain.getBrief();
		this.isDeleted = domain.isDeleted();
		this.enabled = domain.isEnabled();
		this.creationDate = domain.getCreationDate();
		if (domain.getGender() != null)
			this.gender = Gender.valueOf(domain.getGender().toString()).toString();
		if(domain.getNationality() != null)
			this.nationality = new NationalityDTO(domain.getNationality().getId(), domain.getNationality().getNameEn());
		if(domain.getCountry() != null)
			this.country = new CountryDTO(domain.getCountry().getId(), domain.getCountry().getNameEn());
		if(domain.getAreaOfResidence() != null)
			this.areaOfResidence = new ResidenceDTO(domain.getAreaOfResidence().getId(), domain.getAreaOfResidence().getNameEn());
		if(domain.getAccountType() != null)
			this.accountType = domain.getAccountType().toString();
		if(domain.getRoles() != null && !domain.getRoles().isEmpty()) {
			for (Role role : domain.getRoles()) {
				RoleDTO roleDto = new RoleDTO(role.getId(), role.getName());
				if(role.getPermissions() != null && !role.getPermissions().isEmpty()) {
					for (Permission permission : role.getPermissions()) {
						roleDto.getPermissions().add(new PermissionDTO(permission.getId(), permission.getCode()));
					}
				}
				this.roles.add(roleDto);
			}
		}
		return this;
	}

//
}
