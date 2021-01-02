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
import com.zo2ami.dto.CancelEntityDTO;
import com.zo2ami.dto.ErrorDTO;
import com.zo2ami.entity.Activity;
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
		activityService.createActivity(activityDto.toDomain());
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
	
	@PostMapping("/cancel-activity")
	public ResponseEntity<ErrorDTO> cancelActivity(@RequestBody CancelEntityDTO cancelEntityDTO){
		if(cancelEntityDTO.getEntityId() == null)
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.MISSING_ID), HttpStatus.BAD_REQUEST);
		if(cancelEntityDTO.getCancelReson() == null || cancelEntityDTO.getCancelReson().isEmpty())
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.MISSING_CANCEL_REASON), HttpStatus.BAD_REQUEST);
		Activity activity = activityService.findById(cancelEntityDTO.getEntityId());
		if(activity == null)
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.INVALID_ID), HttpStatus.BAD_REQUEST);
		activityService.cancel(activity, cancelEntityDTO.getCancelReson());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/approve/{activityId}")
	public ResponseEntity<ErrorDTO> approveActivity(@PathVariable Long activityId){
		if(activityId == null)
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.MISSING_ID), HttpStatus.BAD_REQUEST);
		Activity activity = activityService.findById(activityId);
		if(activity == null)
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.INVALID_ID), HttpStatus.BAD_REQUEST);
		if(!activityService.canApprove())
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		activityService.approve(activity);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
}
