package com.zo2ami.dto;

import java.io.Serializable;

public class CancelEntityDTO implements Serializable {

	private static final long serialVersionUID = -1344665536954637854L;
	
	private Long entityId;
	
	private String cancelReson;
	
	

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public String getCancelReson() {
		return cancelReson;
	}

	public void setCancelReson(String cancelReson) {
		this.cancelReson = cancelReson;
	}
	
	

	
}
