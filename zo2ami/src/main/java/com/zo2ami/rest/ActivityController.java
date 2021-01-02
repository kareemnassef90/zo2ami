package com.zo2ami.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zo2ami.dto.ActivityDTO;
import com.zo2ami.dto.ErrorDTO;
import com.zo2ami.enums.ErrorCodes;
import com.zo2ami.service.ActivityService;

@RestController
@RequestMapping("/category")
public class ActivityController {
	
	@Autowired
	ActivityService activityService;

	
	@PostMapping("/add-activity")
	public ResponseEntity<List<ErrorDTO>> createActivity(@RequestBody ActivityDTO activityDto){
		List<ErrorDTO> errors = new ArrayList<>();
		if(activityDto.getNameAr() == null || activityDto.getNameAr().isEmpty())
			errors.add(new ErrorDTO(ErrorCodes.MISSING_ACTIVITY_NAME_AR));
		if(activityDto.getNameEn() == null || activityDto.getNameEn().isEmpty())
			errors.add(new ErrorDTO(ErrorCodes.MISSING_ACTIVITY_NAME_EN));
		if(activityDto.getPrice() == null)
			errors.add(new ErrorDTO(ErrorCodes.MISSING_ACTIVITY_PRICE));
		if(activityDto.getStartDate() == null)
			errors.add(new ErrorDTO(ErrorCodes.MISSING_ACTIVITY_START_DATE));
		if(activityDto.getEndDate() == null)
			errors.add(new ErrorDTO(ErrorCodes.MISSING_ACTIVITY_END_DATE));
		if(!errors.isEmpty())	
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		activityService.save(activityDto.toDomain());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/list-activities")
	public ResponseEntity<List<ActivityDTO>> listAll(){
		List<ActivityDTO> activityDTOs = new ArrayList<>();
		activityService.list().stream().forEach(activity -> activityDTOs.add(new ActivityDTO().toDto(activity)));
		return new ResponseEntity<> (activityDTOs, HttpStatus.OK);
	}
	
	@GetMapping("/list-category-activities/{categoryId}")
	public ResponseEntity<List<ActivityDTO>> listAllByCategory(@PathVariable Long categoryId){
		List<ActivityDTO> activityDTOs = new ArrayList<>();
		activityService.listByCategory(categoryId).stream().forEach(activity -> activityDTOs.add(new ActivityDTO().toDto(activity)));
		return new ResponseEntity<> (activityDTOs, HttpStatus.OK);
	}

	
	
}
