package com.zo2ami.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.Activity;
import com.zo2ami.repo.ActivityRepository;

@Service
public class ActivityService {

	@Autowired
	ActivityRepository activityRepository;

	public void save(Activity activity) {
		activity.setCreationDate(new Date());
		activityRepository.save(activity);
	}
	
	
	public List<Activity> list(){
		return (List<Activity>) activityRepository.findAll();
	}
	
	public List<Activity> listByCategory(Long categoryId){
		return  activityRepository.findAllByCategoryId(categoryId);
	}
	
}
