package com.zo2ami.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.zo2ami.entity.Customer;
import com.zo2ami.entity.Residence;
import com.zo2ami.entity.ServiceProvider;
import com.zo2ami.entity.Subscriber;
import com.zo2ami.entity.User;
import com.zo2ami.enums.AccountType;
import com.zo2ami.enums.Gender;

@JsonInclude(Include.NON_NULL)
public class UserDTO extends CommonDTOWithErrors {

	private static final long serialVersionUID = 9055050716203676696L;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String confirmPassword;
	
	private String mobileNumber;
	
	private String mobileNumber2;
	
	private String mobileNumber3;
	
	private Gender gender;
	
	private Date dateOfBirth;
	
	private Long nationality;
	
	private Long residence;
	
	private String prief;
	
	private String accountType; 
	
	private String contactPersonName;
	
	private String location;
	
	
	
	

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getMobileNumber2() {
		return mobileNumber2;
	}

	public String getMobileNumber3() {
		return mobileNumber3;
	}

	public Gender getGender() {
		return gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public Long getNationality() {
		return nationality;
	}

	public Long getResidence() {
		return residence;
	}

	public String getPrief() {
		return prief;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public String getLocation() {
		return location;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setMobileNumber2(String mobileNumber2) {
		this.mobileNumber2 = mobileNumber2;
	}

	public void setMobileNumber3(String mobileNumber3) {
		this.mobileNumber3 = mobileNumber3;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setNationality(Long nationality) {
		this.nationality = nationality;
	}

	public void setResidence(Long residence) {
		this.residence = residence;
	}

	public void setPrief(String prief) {
		this.prief = prief;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	public UserDTO toDTO(User domain) {
		
		return new UserDTO();
	}

	
	public Customer toDomain(UserDTO dto) {
		
		Customer customer = new Customer();
		customer.setCreationDate(new Date());
		customer.setDateOfBiorth(dto.getDateOfBirth());
		customer.setDeleted(false);
		customer.setEmail(dto.getEmail());
		customer.setEnabled(true);
		customer.setGender(dto.getGender());
		customer.setMobileNumber(dto.getMobileNumber());
		customer.setMobileNumber2(dto.getMobileNumber2());
		customer.setMobileNumber3(dto.getMobileNumber3());
		customer.setUsername(dto.getUsername());
		customer.setPassword(dto.getPassword());
		customer.setBrief(dto.getPrief());
		if(dto.getResidence() != null) {
			Residence residence = new Residence();
			residence.setId(dto.getResidence());
			customer.setAreaOfResidence(residence);
		}
		if(dto.getAccountType().equals(AccountType.SUBSCRIBER.toString())) {
			Subscriber subscriber = (Subscriber) customer;
			return subscriber;
		}
		if(dto.getAccountType().equals(AccountType.SERVICE_PROVIDER.toString())) {
			ServiceProvider provider = (ServiceProvider) customer;
			return provider;
		}
		
		
		return null;
	}

	public List<ErrorDTO> validate() {
		if(this.username == null || this.username.isEmpty()) {
			
		}
			
		return null;
	}
	
	
	
	
	
	
}
