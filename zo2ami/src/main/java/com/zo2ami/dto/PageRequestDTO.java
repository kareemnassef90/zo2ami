package com.zo2ami.dto;

import java.io.Serializable;

public class PageRequestDTO implements Serializable {

	private static final long serialVersionUID = 7223365222693018605L;
	
	private int pageNumber;
	
	private int pageSize;

	
	
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	
	

}
