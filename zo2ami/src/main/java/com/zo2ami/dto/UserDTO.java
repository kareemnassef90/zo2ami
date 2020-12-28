package com.zo2ami.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.zo2ami.entity.Residence;
import com.zo2ami.entity.ServiceProvider;
import com.zo2ami.entity.Subscriber;
import com.zo2ami.entity.User;
import com.zo2ami.enums.AccountType;
import com.zo2ami.enums.ErrorCodes;
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
	
	private String contactPersonEmail;
	
	private String contactPersonMobileNumber;
	
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
	
	public String getContactPersonEmail() {
		return contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	public String getContactPersonMobileNumber() {
		return contactPersonMobileNumber;
	}

	public void setContactPersonMobileNumber(String contactPersonMobileNumber) {
		this.contactPersonMobileNumber = contactPersonMobileNumber;
	}

	public UserDTO toDTO(User domain) {
		
		return new UserDTO();
	}
	

	public Subscriber toSubscriberDomain(UserDTO dto) {
		
		Subscriber subscriber = new Subscriber();
		subscriber.setCreationDate(new Date());
		subscriber.setDateOfBiorth(dto.getDateOfBirth());
		subscriber.setDeleted(false);
		subscriber.setEmail(dto.getEmail());
		subscriber.setEnabled(true);
		subscriber.setGender(dto.getGender());
		subscriber.setMobileNumber(dto.getMobileNumber());
		subscriber.setMobileNumber2(dto.getMobileNumber2());
		subscriber.setMobileNumber3(dto.getMobileNumber3());
		subscriber.setUsername(dto.getUsername());
		subscriber.setPassword(dto.getPassword());
		subscriber.setBrief(dto.getPrief());
		if(dto.getResidence() != null) {
			Residence residence = new Residence();
			residence.setId(dto.getResidence());
			subscriber.setAreaOfResidence(residence);
		}
		return subscriber;
	}
	
	
	public ServiceProvider toServiceProviderDomain(UserDTO dto) {
			
		ServiceProvider serviceProvider = new ServiceProvider();
		serviceProvider.setCreationDate(new Date());
		serviceProvider.setDateOfBiorth(dto.getDateOfBirth());
		serviceProvider.setDeleted(false);
		serviceProvider.setEmail(dto.getEmail());
		serviceProvider.setEnabled(true);
		serviceProvider.setGender(dto.getGender());
		serviceProvider.setMobileNumber(dto.getMobileNumber());
		serviceProvider.setMobileNumber2(dto.getMobileNumber2());
		serviceProvider.setMobileNumber3(dto.getMobileNumber3());
		serviceProvider.setUsername(dto.getUsername());
		serviceProvider.setPassword(dto.getPassword());
		serviceProvider.setBrief(dto.getPrief());
		serviceProvider.setContactPersonName(dto.getContactPersonName());
		serviceProvider.setContactPersonEmail(dto.getContactPersonEmail());
		serviceProvider.setContactPersonMobile(dto.getContactPersonMobileNumber());
		serviceProvider.setLocation(dto.getLocation());
		
		if(dto.getResidence() != null) {
			Residence residence = new Residence();
			residence.setId(dto.getResidence());
			serviceProvider.setAreaOfResidence(residence);
		}
		return serviceProvider;
	}

	public List<ErrorDTO> validate() {
		List<ErrorDTO> errors = new ArrayList<>();
		if(this.username == null || this.username.isEmpty())
			errors.add(new ErrorDTO(ErrorCodes.MISSING_USERNAME));
		if(this.email == null || this.email.isEmpty())
			errors.add(new ErrorDTO(ErrorCodes.MISSING_EMAIL));
		if(this.password == null || this.password.isEmpty())
			errors.add(new ErrorDTO(ErrorCodes.MISSING_PASSWORD));
		if(this.confirmPassword == null || this.confirmPassword.isEmpty())
			errors.add(new ErrorDTO(ErrorCodes.MISSING_CONFIRM_PASSWORD));
		if(this.confirmPassword != null && this.password != null && !this.password.equals(this.confirmPassword))
			errors.add(new ErrorDTO(ErrorCodes.PASSWORDS_MISMATCH));
		if(this.mobileNumber == null || this.mobileNumber.isEmpty())
			errors.add(new ErrorDTO(ErrorCodes.MISSING_MOBILE_NUMBER));
		if(this.accountType == null || this.accountType.isEmpty()) {
			errors.add(new ErrorDTO(ErrorCodes.MISSING_ACCOUNT_TYPE));
		} else {
			validateByAccountType(errors);
		}
		return errors;
	}

	private void validateByAccountType(List<ErrorDTO> errors) {
		if(this.accountType.equals(AccountType.SERVICE_PROVIDER.toString())) {
			if(this.contactPersonName == null || this.contactPersonName.isEmpty())
				errors.add(new ErrorDTO(ErrorCodes.MISSING_CONTACT_PERSON_NAME));
			if(this.contactPersonName == null || this.contactPersonName.isEmpty())
				errors.add(new ErrorDTO(ErrorCodes.MISSING_CONTACT_PERSON_EMAIL));
			if(this.contactPersonMobileNumber == null || this.contactPersonMobileNumber.isEmpty())
				errors.add(new ErrorDTO(ErrorCodes.MISSING_CONTACT_PERSON_MOBILE_NUMBER));
			if(this.location == null || this.location.isEmpty())
				errors.add(new ErrorDTO(ErrorCodes.MISSING_LOCATION));
//			if(this.LegalDocument == null)
//				errors.add(new ErrorDTO(ErrorCodes.MISSING_LEGAL_DOCUMENT));
		}
	}
	
	
	
	
	
	
}
