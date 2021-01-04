package com.zo2ami.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageDTO<T> implements Serializable {

	private static final long serialVersionUID = 5374753296834341172L;
	
	private List<T> list = new ArrayList<>();
	
	private Long totalCount;
	
	

	public List<T> getList() {
		return list;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	
	
	

}
