package com.zo2ami.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.zo2ami.entity.Country;
import com.zo2ami.entity.Customer;
import com.zo2ami.entity.Nationality;
import com.zo2ami.entity.Permission;
import com.zo2ami.entity.Residence;
import com.zo2ami.entity.Role;
import com.zo2ami.entity.ServiceProvider;
import com.zo2ami.enums.AccountType;
import com.zo2ami.enums.Gender;


@JsonInclude(Include.NON_EMPTY)
public class CustomerDTO extends CommonDTOWithErrors implements Serializable {

	private static final long serialVersionUID = 6445731753329096797L;

	private Long id;

	private String username;

	private String email;

	private String password;

	private String mobileNumber;

	private String mobileNumber2;

	private String mobileNumber3;

	private Date dateOfBirth;

	private String gender;

	private Boolean isDeleted;

	private Boolean enabled;

	private Date creationDate;

	private List<RoleDTO> roles = new ArrayList<>();

	private NationalityDTO nationality;

	private CountryDTO country;

	private ResidenceDTO areaOfResidence;

	private String brief;
	
	private String accountType;
	
	private String contactPersonName ;
	
	private String contactPersonEmail ;
	
	private String contactPersonMobile ;
	
	private String location;
	
	
	public CustomerDTO(){
		
	}
	
	public CustomerDTO(ErrorDTO error) {
		this.getErrors().add(error);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
		if(domain.getAccountType().equals(AccountType.SERVICE_PROVIDER)) {
			ServiceProvider provider = (ServiceProvider) domain;
			this.contactPersonName = provider.getContactPersonName();
			this.contactPersonEmail = provider.getContactPersonEmail();
			this.contactPersonMobile = provider.getContactPersonMobile();
			this.location = provider.getLocation();
		}
		return this;
	}

	public Customer update(Customer customer) {
		if(this.mobileNumber!= null && !this.mobileNumber.isEmpty())
			customer.setMobileNumber(this.mobileNumber);
		if(this.mobileNumber2 != null && !this.mobileNumber2.isEmpty())
			customer.setMobileNumber2(this.mobileNumber2);
		if(this.mobileNumber3 != null && !this.mobileNumber3.isEmpty())
			customer.setMobileNumber3(this.mobileNumber3);
		if(this.dateOfBirth != null)
			customer.setDateOfBirth(this.dateOfBirth);
		if(this.brief != null && !this.brief.isEmpty())
			customer.setBrief(this.brief);
		if(this.isDeleted != null)
			customer.setDeleted(this.isDeleted);
		if(this.enabled != null)
			customer.setEnabled(this.enabled);
		if(this.gender != null && !this.gender.isEmpty())
			customer.setGender(Gender.valueOf(this.gender));
		if(this.nationality != null && this.nationality.getId() != null)
			customer.setNationality(new Nationality(this.nationality.getId()));
		if(this.country != null && this.country.getId() != null)
			customer.setCountry(new Country(this.country.getId()));
		if(this.areaOfResidence != null && this.areaOfResidence.getId() != null)
			customer.setAreaOfResidence(new Residence(this.areaOfResidence.getId()));
		
		
		if(customer.getAccountType().equals(AccountType.SUBSCRIBER)) {
//			Subscriber subscriber = (Subscriber) customer;
			
		}else if(customer.getAccountType().equals(AccountType.SERVICE_PROVIDER)){
			ServiceProvider provider = (ServiceProvider) customer;
			if(this.contactPersonName != null && !this.contactPersonName.isEmpty())
				provider.setContactPersonName(this.contactPersonName);
			if(this.contactPersonEmail != null && !this.contactPersonEmail.isEmpty())
				provider.setContactPersonEmail(this.contactPersonEmail);
			if(this.contactPersonMobile != null && !this.contactPersonMobile.isEmpty())
				provider.setContactPersonMobile(this.contactPersonMobile);
		}
		return customer;
	}

//
}
