package com.zo2ami.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zo2ami.dto.CategoryActivityRelationDTO;
import com.zo2ami.dto.ErrorDTO;
import com.zo2ami.entity.Activity;
import com.zo2ami.entity.Category;
import com.zo2ami.enums.ErrorCodes;
import com.zo2ami.service.ActivityService;
import com.zo2ami.service.CategoryService;

@RestController
@RequestMapping("/category-activity")
public class CategoryActivityController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ActivityService activityService;

	@PostMapping("/assign-activity-category")
	public ResponseEntity<ErrorDTO> assignActivityToCategory(@RequestBody CategoryActivityRelationDTO categoryActivityRelationDTO){
		if(categoryActivityRelationDTO.getActivityId() == null)
			new ResponseEntity<>(new ErrorDTO(ErrorCodes.MISSING_ACTIVITY_ID), HttpStatus.BAD_REQUEST);
		if(categoryActivityRelationDTO.getCategoryId() == null)
			new ResponseEntity<>(new ErrorDTO(ErrorCodes.MISSING_CATEGORY_ID), HttpStatus.BAD_REQUEST);
		Activity activity =  activityService.findById(categoryActivityRelationDTO.getActivityId());
		if(activity == null)
			new ResponseEntity<>(new ErrorDTO(ErrorCodes.ACTIVITY_NOT_FOUND), HttpStatus.BAD_REQUEST);
		Category category = categoryService.findById(categoryActivityRelationDTO.getCategoryId());
		if(category == null)
			new ResponseEntity<>(new ErrorDTO(ErrorCodes.CATEGORY_NOT_FOUND), HttpStatus.BAD_REQUEST);
		categoryService.assign(category, activity);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/unassign-activity-category")
	public ResponseEntity<ErrorDTO> unassignActivityToCategory(@RequestBody CategoryActivityRelationDTO categoryActivityRelationDTO){
		if(categoryActivityRelationDTO.getActivityId() == null)
			new ResponseEntity<>(new ErrorDTO(ErrorCodes.MISSING_ACTIVITY_ID), HttpStatus.BAD_REQUEST);
		if(categoryActivityRelationDTO.getCategoryId() == null)
			new ResponseEntity<>(new ErrorDTO(ErrorCodes.MISSING_CATEGORY_ID), HttpStatus.BAD_REQUEST);
		Activity activity =  activityService.findById(categoryActivityRelationDTO.getActivityId());
		if(activity == null)
			new ResponseEntity<>(new ErrorDTO(ErrorCodes.ACTIVITY_NOT_FOUND), HttpStatus.BAD_REQUEST);
		Category category = categoryService.findById(categoryActivityRelationDTO.getCategoryId());
		if(category == null)
			new ResponseEntity<>(new ErrorDTO(ErrorCodes.CATEGORY_NOT_FOUND), HttpStatus.BAD_REQUEST);
		categoryService.unassign(category, activity);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
