package com.zo2ami.dto;

import java.util.Date;

import com.zo2ami.entity.BookingRequest;

public class BookingRequestDTO extends CommonDTOWithErrors {

	private static final long serialVersionUID = -9135547073079656832L;
	
	
private Long id;
	
	private Date creationDate;
	
	private ActivityDTO activity;
	
	private UserDTO subscriber;
	
	private Boolean approved;
	
	private Boolean paid;
	
	private String paymentMethod;
	
	private Boolean canceled;
	
	private Boolean cancellationApproved;
	
	private UserDTO canceledBy;
	
	private String cancelReson;
	
	private Date cancellationdate;
	
	
	
	public BookingRequestDTO(){}
	
	public BookingRequestDTO(ErrorDTO errorDto){
		this.getErrors().add(errorDto);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public ActivityDTO getActivity() {
		return activity;
	}

	public void setActivity(ActivityDTO activity) {
		this.activity = activity;
	}

	public UserDTO getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(UserDTO subscriber) {
		this.subscriber = subscriber;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Boolean getCanceled() {
		return canceled;
	}

	public void setCanceled(Boolean canceled) {
		this.canceled = canceled;
	}

	public Boolean getCancellationApproved() {
		return cancellationApproved;
	}

	public void setCancellationApproved(Boolean cancellationApproved) {
		this.cancellationApproved = cancellationApproved;
	}

	public UserDTO getCanceledBy() {
		return canceledBy;
	}

	public void setCanceledBy(UserDTO canceledBy) {
		this.canceledBy = canceledBy;
	}

	public String getCancelReson() {
		return cancelReson;
	}

	public void setCancelReson(String cancelReson) {
		this.cancelReson = cancelReson;
	}

	public Date getCancellationdate() {
		return cancellationdate;
	}

	public void setCancellationdate(Date cancellationdate) {
		this.cancellationdate = cancellationdate;
	}
	
	
	public BookingRequestDTO toDto(BookingRequest domain) {
		this.id = domain.getId();
		this.canceled = domain.getCanceled();
		this.approved = domain.getApproved();
		this.cancellationApproved = domain.getCancellationApproved();
		this.cancellationdate = domain.getCancellationdate();
		this.cancelReson = domain.getCancelReson();
		this.paid = domain.getPaid();
		if(domain.getPaymentMethod() != null)
			this.paymentMethod = domain.getPaymentMethod().toString();
		if(domain.getCanceledBy() != null)
			this.canceledBy = new UserDTO().toDTO(domain.getCanceledBy());
		if(domain.getSubscriber() != null)
			this.subscriber = new UserDTO().toDTO(domain.getSubscriber());
		if(domain.getActivity() != null)
			this.activity = new ActivityDTO().toDto(domain.getActivity());
		return this;
	}

}
