package com.zo2ami.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	
	private Boolean discounted;
	
	private Double originalPrice;
	
	private int rateCount;
	
	private Boolean available;
	
	private CustomerDTO serviceProvider;
	
	@JsonFormat
	  (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date startDate;
	
	@JsonFormat
	  (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date endDate;
	
	@JsonFormat
	  (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date lastBookingDate;
	
	
	

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
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Date getLastBookingDate() {
		return lastBookingDate;
	}

	public void setLastBookingDate(Date lastBookingDate) {
		this.lastBookingDate = lastBookingDate;
	}
	
	public Boolean getDiscounted() {
		return discounted;
	}

	public void setDiscounted(Boolean discounted) {
		this.discounted = discounted;
	}

	public Double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public int getRateCount() {
		return rateCount;
	}

	public void setRateCount(int rateCount) {
		this.rateCount = rateCount;
	}
	
	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public ActivityDTO toDto(Activity activity) {
		this.id = activity.getId();
		this.nameAr = activity.getNameAr();
		this.nameEn = activity.getNameEn();
		this.price = activity.getPrice();
		this.brief = activity.getBrief();
		this.rate = activity.getRate();
		this.startDate = activity.getStartDate();
		this.endDate = activity.getEndDate();
		this.rateCount = activity.getRateCount();
		this.originalPrice = activity.getOriginalPrice();
		this.discounted = activity.getDiscounted();
		this.lastBookingDate = activity.getLastBookingDate();
		if(activity.getLastBookingDate() != null)
			this.available = activity.getLastBookingDate().before(new Date());
		else if(activity.getStartDate() != null)
			this.available = activity.getStartDate().before(new Date());
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
		activity.setStartDate(this.startDate);
		activity.setEndDate(this.endDate);
		activity.setLastBookingDate(this.lastBookingDate);
		activity.setDiscounted(this.discounted);
		activity.setOriginalPrice(this.originalPrice);
		activity.setRateCount(this.rateCount);
		if(this.serviceProvider != null && this.serviceProvider.getId() != null) {
			ServiceProvider provider = new ServiceProvider();
			provider.setId(this.serviceProvider.getId());
			activity.setServiceProvider(provider);
		}
			
		return activity;
	}
	
	
	

}
