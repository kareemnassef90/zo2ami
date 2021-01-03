package com.zo2ami.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zo2ami.enums.PaymentMethod;

@Entity
@Table(name = "booking_request")
public class BookingRequest {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "creation_date")
	private Date creationDate;
	
	@ManyToOne
	@JoinColumn(name = "activity_id")
	private Activity activity;
	
	@ManyToOne
	@JoinColumn(name = "subscriber_id")
	private User subscriber;
	
	@Column(name = "paid")
	private Boolean paid;
	
	@Column(name = "payment_method")
	private PaymentMethod paymentMethod;
	
	@Column(name = "canceled")
	private Boolean canceled;
	
	@Column(name= "cancellation_approved")
	private Boolean cancellationApproved;
	
	@ManyToOne
	@JoinColumn(name = "canceld_by_id")
	private User canceledBy;
	
	@Column(name = "cancel_reason")
	private String cancelReson;
	
	@Column(name= "cancellation_date")
	private Date cancellationdate;
	
	
	
	
	

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

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public User getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(User subscriber) {
		this.subscriber = subscriber;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public Boolean getCanceled() {
		return canceled;
	}

	public void setCanceled(Boolean canceled) {
		this.canceled = canceled;
	}

	public User getCanceledBy() {
		return canceledBy;
	}

	public void setCanceledBy(User canceledBy) {
		this.canceledBy = canceledBy;
	}

	public String getCancelReson() {
		return cancelReson;
	}

	public void setCancelReson(String cancelReson) {
		this.cancelReson = cancelReson;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Boolean getCancellationApproved() {
		return cancellationApproved;
	}

	public void setCancellationApproved(Boolean cancellationApproved) {
		this.cancellationApproved = cancellationApproved;
	}

	public Date getCancellationdate() {
		return cancellationdate;
	}

	public void setCancellationdate(Date cancellationdate) {
		this.cancellationdate = cancellationdate;
	}


	
	
	

}
