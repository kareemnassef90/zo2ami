package com.zo2ami.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceProviderDTO implements Serializable {

	private static final long serialVersionUID = 4406961979425161959L;
	
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
	
	

}
