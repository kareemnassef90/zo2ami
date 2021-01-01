package com.zo2ami.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.TableGenerator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.zo2ami.enums.AccountType;
import com.zo2ami.enums.Gender;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class User implements UserDetails ,Serializable{
	
	private static final long serialVersionUID = -3308435123168651863L;

	@TableGenerator(name="USER_GEN", pkColumnName="sequence_name", pkColumnValue="USER", table="sequence_table", initialValue=0, valueColumnName="hi", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="USER_GEN")
	@Id
	private long id ;
	
	@Column(name = "username")
	private String username ;
	
	@Column(name = "email")
	private String email ;
	
	@Column(name = "password")
	private String password ;
	
	@Column(name = "mobile_number")
	private String mobileNumber ;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender ;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "account_type")
	private AccountType accountType;
	
	@Column(name = "deleted")
	private boolean isDeleted ;
	
	@Column(name = "enabled")
	private boolean enabled ; 
	
	@Column(name = "creation_date")
	private Date creationDate ;
	
	@Column(name = "last_update_date")
	private Date lastUpdateDate ;
	
	@ManyToMany
	@JoinTable(name = "user_role", 
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
	
	

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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBiorth) {
		this.dateOfBirth = dateOfBiorth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isEnabled();
	}

	@Override
	public boolean isAccountNonLocked() {
		return isEnabled();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isEnabled();
	}
	
	
	
	
	
	
	
	

	

}
