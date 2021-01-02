package com.zo2ami.dto;

import java.io.Serializable;

import com.zo2ami.entity.Category;

public class CategoryDTO implements Serializable{

	private static final long serialVersionUID = -3080558945235655141L;
	
	private Long id;
	
	private String nameAr;
	
	private String nameEn;
	
	private Integer displayOrder;
	
	

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
	
	public Category toDomain(CategoryDTO categoryDto) {
		Category category = new Category();
		category.setNameAr(this.nameAr);
		category.setNameEn(this.nameEn);
		category.setDisplayOrder(this.displayOrder);
		return category;
	}
	
	public CategoryDTO toDto(Category category) {
		this.id = category.getId();
		this.nameAr = category.getNameAr();
		this.nameEn = category.getNameEn();
		this.displayOrder = category.getDisplayOrder();
		return this;
	}
	
	
	

}
