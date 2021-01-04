package com.zo2ami.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.Activity;
import com.zo2ami.entity.Category;
import com.zo2ami.repo.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	
	public void create(Category category) {
		category.setCreationDate(new Date());
		category.setEnabled(true);
		categoryRepository.save(category);
	}
	
	public List<Category> list() {
		return (List<Category>) categoryRepository.findAll();
	}

	public Category findById(Long categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		return category.isPresent() ? category.get() : null;
	}
	
	public void assign(Category category, Activity activity) {
		category.getActivities().add(activity);
		categoryRepository.save(category);
	}

	public void unassign(Category category, Activity activity) {
		category.getActivities().removeIf(a -> a.getId().equals(activity.getId()));
		categoryRepository.save(category);
	}
}
