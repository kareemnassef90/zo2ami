package com.zo2ami.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.Category;
import com.zo2ami.repo.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	
	public void save(Category category) {
		category.setCreationDate(new Date());
		categoryRepository.save(category);
	}
	
	public List<Category> list() {
		return (List<Category>) categoryRepository.findAll();
	}
}
