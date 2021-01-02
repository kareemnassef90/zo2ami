package com.zo2ami.dto;

import java.io.Serializable;

import com.zo2ami.entity.Activity;
import com.zo2ami.entity.ServiceProvider;

public class ActivityDTO implements Serializable {
	
	private static final long serialVersionUID = -4112202798646283502L;

	private Long id;
	
	private String nameAr;
	
	private String nameEn;
	
	private String brief;
	
	private Integer rate;
	
	private Double price;
	
	private CustomerDTO serviceProvider;
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameAr() {
		return nameAr;
	}

	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public CustomerDTO getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(CustomerDTO serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	
	public ActivityDTO toDto(Activity activity) {
		this.id = activity.getId();
		this.nameAr = activity.getNameAr();
		this.nameEn = activity.getNameEn();
		this.price = activity.getPrice();
		this.brief = activity.getBrief();
		this.rate = activity.getRate();
		if(activity.getServiceProvider() != null)
			this.serviceProvider = new CustomerDTO().toDto(activity.getServiceProvider());
		return this;
	}
	
	public Activity toDomain() {
		Activity activity = new Activity();
		activity.setNameAr(this.nameAr);
		activity.setNameEn(this.nameEn);
		activity.setBrief(this.brief);
		activity.setPrice(this.price);
		activity.setRate(this.rate);
		if(this.serviceProvider != null && this.serviceProvider.getId() != null) {
			ServiceProvider provider = new ServiceProvider();
			provider.setId(this.serviceProvider.getId());
			activity.setServiceProvider(provider);
		}
			
		return activity;
	}
	
	
	

}
