package com.zo2ami.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.zo2ami.entity.Category;

public class CategoryDTO implements Serializable{

	private static final long serialVersionUID = -3080558945235655141L;
	
	private Long id;
	
	private boolean enabled;
	
	private String nameAr;
	
	private String nameEn;
	
	private Integer displayOrder;
	
	private List<ActivityDTO> activites = new ArrayList<>();
	
	

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

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<ActivityDTO> getActivites() {
		return activites;
	}

	public void setActivites(List<ActivityDTO> activites) {
		this.activites = activites;
	}

	public Category toDomain(CategoryDTO categoryDto) {
		Category category = new Category();
		category.setNameAr(this.nameAr);
		category.setNameEn(this.nameEn);
		category.setDisplayOrder(this.displayOrder);
		category.setEnabled(this.enabled);
		return category;
	}
	
	public CategoryDTO toDto(Category category) {
		this.id = category.getId();
		this.nameAr = category.getNameAr();
		this.nameEn = category.getNameEn();
		this.enabled = category.isEnabled();
		this.displayOrder = category.getDisplayOrder();
		if(category.getActivities() != null)
			category.getActivities().stream().forEach(activity -> this.getActivites().add(new ActivityDTO().toDto(activity)));
		return this;
	}
	
	
	

}
