package com.zo2ami.dto;

import java.io.Serializable;

public class CategoryActivityRelationDTO implements Serializable {
	
	private static final long serialVersionUID = -5689416758263788832L;

	private Long activityId;
	
	private Long categoryId;
	
	

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	
	

}
