package com.zo2ami.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.Activity;
import com.zo2ami.entity.User;
import com.zo2ami.enums.AccountType;
import com.zo2ami.repo.ActivityRepository;

@Service
public class ActivityService {

	@Autowired
	ActivityRepository activityRepository;
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	public void createActivity(Activity activity) {
		User loggedInUser = userDetailsService.getLoggedInUser();
		if(loggedInUser.getAccountType().equals(AccountType.ADMIN)) {
			activity.setApproved(true);
		}
		activity.setCreatedBy(loggedInUser);
		activity.setCreationDate(new Date());
		activityRepository.save(activity);
	}
	
	
	public Page<Activity> list(int pageNumber, int pageSize){
		Pageable page = PageRequest.of(pageNumber - 1, pageSize);
		return  activityRepository.findAll(page);
	}
	
	public List<Activity> listByCategory(Long categoryId){
		return  activityRepository.findAllByCategoryId(categoryId);
	}
	
	public Activity findById(Long id){
		Optional<Activity> activity = activityRepository.findById(id);
		return activity.isPresent() ? activity.get() : null;
	}
	
	
	public void cancel(Activity activity, String cancelReson) {
		User loggedInUser = userDetailsService.getLoggedInUser();
		if(loggedInUser.getAccountType().equals(AccountType.ADMIN)) {
			activity.setCancellationApproved(true);
		}
		activity.setCanceled(true);
		activity.setCancelReason(cancelReson);
		activity.setCanceldBy(loggedInUser);
		activity.setCancellationdate(new Date());
		activityRepository.save(activity);
		
	}


	public boolean canApprove() {
		return userDetailsService.getLoggedInUser().getAccountType().equals(AccountType.ADMIN);
	}
	
	public void approve(Activity activity) {
		if(userDetailsService.getLoggedInUser().getAccountType().equals(AccountType.ADMIN)) {
			activity.setApproved(true);
		}
	}


	public void approveCancellation(Activity activity) {
		if(userDetailsService.getLoggedInUser().getAccountType().equals(AccountType.ADMIN))
			activity.setCancellationApproved(true);
		
	}


	public Page<Activity> listAvailableAtivities(int pageNumber, int pageSize){
		Pageable page = PageRequest.of(pageNumber - 1, pageSize);
		return activityRepository.findAvailableActivities(page);
	}
	
	
	
}
