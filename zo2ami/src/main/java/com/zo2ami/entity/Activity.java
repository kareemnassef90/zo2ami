package com.zo2ami.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zo2ami.enums.ActivityType;

@Entity
@Table(name = "activity")
public class Activity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name_ar")
	private String nameAr;
	
	@Column(name = "name_en")
	private String nameEn;
	
	@Column(name = "brief")
	private String brief;
	
	@Column(name = "rate")
	private Integer rate;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "creation_date")
	private Date creationDate ;
	
	@ManyToOne
	@JoinColumn(name = "created_by_id")
	private User createdBy ;
	
	@Column(name = "start_date")
	private Date startDate ;
	
	@Column(name = "last_booking_date")
	private Date lastBookingDate ;
	
	@Column(name = "end_date")
	private Date endDate ;
	
	@Column(name = "approved")
	private Boolean approved;
	
	@Column(name= "canceled")
	private Boolean canceled;
	
	@Column(name= "cancellation_approved")
	private Boolean cancellationApproved;
	
	@Column(name= "cancellation_date")
	private Date cancellationdate;
	
	@Column(name= "cancel_reason")
	private String cancelReason;
	
	@ManyToOne
	@JoinColumn(name = "canceld_by_id")
	private User canceldBy;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "activity_type")
	private ActivityType activityType;
	
	@ManyToOne
	@JoinColumn(name = "service_provider_id")
	private ServiceProvider serviceProvider;
	
	
	
	
	
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

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public Boolean getCanceled() {
		return canceled;
	}

	public void setCanceled(Boolean canceled) {
		this.canceled = canceled;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public User getCanceldBy() {
		return canceldBy;
	}

	public void setCanceldBy(User canceldBy) {
		this.canceldBy = canceldBy;
	}

	public Date getLastBookingDate() {
		return lastBookingDate;
	}

	public void setLastBookingDate(Date lastBookingDate) {
		this.lastBookingDate = lastBookingDate;
	}

	public Boolean getCancellationApproved() {
		return cancellationApproved;
	}

	public void setCancellationApproved(Boolean cancellationApproved) {
		this.cancellationApproved = cancellationApproved;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Date getCancellationdate() {
		return cancellationdate;
	}

	public void setCancellationdate(Date cancellationdate) {
		this.cancellationdate = cancellationdate;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	
	
	
	

}
