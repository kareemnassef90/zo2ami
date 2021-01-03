package com.zo2ami.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zo2ami.dto.CancelEntityDTO;
import com.zo2ami.dto.ErrorDTO;
import com.zo2ami.entity.Activity;
import com.zo2ami.entity.BookingRequest;
import com.zo2ami.enums.ErrorCodes;
import com.zo2ami.service.ActivityService;
import com.zo2ami.service.BookingRequestService;

@RestController
@RequestMapping("/book")
public class BookingController {
	
	@Autowired
	BookingRequestService bookingRequestService;
	
	@Autowired
	ActivityService activityService;

	
	@GetMapping("/add-booking/{activityId}")
	public ResponseEntity<ErrorDTO> addBooking(@PathVariable Long activityId){
		if(activityId == null)
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.MISSING_ID), HttpStatus.BAD_REQUEST);
		Activity activity = activityService.findById(activityId);
		if(activity == null)
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.INVALID_ID), HttpStatus.BAD_REQUEST);
		bookingRequestService.addBookingRequest(activity);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PostMapping("/cancel-booking/{bookingRequestId}")
	public ResponseEntity<ErrorDTO> cancelBooking(@RequestBody CancelEntityDTO cancelEntityDTO){
		if(cancelEntityDTO.getEntityId() == null)
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.MISSING_ID), HttpStatus.BAD_REQUEST);
		if(cancelEntityDTO.getCancelReson() == null)
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.MISSING_CANCEL_REASON), HttpStatus.BAD_REQUEST);
		BookingRequest bookingRequest =  bookingRequestService.findById(cancelEntityDTO.getEntityId());
		if(bookingRequest == null)
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.INVALID_ID), HttpStatus.BAD_REQUEST);
		if(!bookingRequestService.canCancele(bookingRequest))
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.CANNOT_CANCEL), HttpStatus.BAD_REQUEST);
		bookingRequestService.cancelRequest(bookingRequest, cancelEntityDTO.getCancelReson());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
//	@GetMapping("/approve/{bookingRequestId}")
//	public ResponseEntity<ErrorDTO> approveBooking(@PathVariable Long bookingRequestId){
//		if(bookingRequestId == null)
//			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.MISSING_ID), HttpStatus.BAD_REQUEST);
//		BookingRequest bookingRequest = bookingRequestService.findById(bookingRequestId);
//		if(bookingRequest == null)
//			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.INVALID_ID), HttpStatus.BAD_REQUEST);
//		if(!bookingRequestService.canApprove())
//			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//		bookingRequestService.approveRequest(bookingRequest);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
	@GetMapping("/approve-cancellation/{bookingRequestId}")
	public ResponseEntity<ErrorDTO> approveCancellation(@PathVariable Long bookingRequestId){
		if(bookingRequestId == null)
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.MISSING_ID), HttpStatus.BAD_REQUEST);
		BookingRequest bookingRequest = bookingRequestService.findById(bookingRequestId);
		if(bookingRequest == null)
			return new ResponseEntity<>(new ErrorDTO(ErrorCodes.INVALID_ID), HttpStatus.BAD_REQUEST);
		if(!bookingRequestService.canApprove())
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		bookingRequestService.approveCancellation(bookingRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
