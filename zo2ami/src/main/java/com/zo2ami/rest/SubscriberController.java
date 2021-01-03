package com.zo2ami.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zo2ami.dto.BookingRequestDTO;
import com.zo2ami.entity.BookingRequest;
import com.zo2ami.service.BookingRequestService;

@RestController
@RequestMapping("/subscriber")
public class SubscriberController {
	
	
	@Autowired
	BookingRequestService bookingRequestService ;
	
	@GetMapping("/current-booking_requests/{subscriberId}")
	public ResponseEntity<List<BookingRequestDTO>> getCurrentBookingRequest(@PathVariable Long subscriberId){
		if(subscriberId != null) {
			List<BookingRequestDTO> requestDTOs = new ArrayList<>();
			List<BookingRequest> requests = bookingRequestService.getSubscriberCurrentBookingRequests(subscriberId);
			for (BookingRequest bookingRequest : requests) {
				requestDTOs.add(new BookingRequestDTO().toDto(bookingRequest));
			}
			return new ResponseEntity<>(requestDTOs, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/past-booking_requests/{subscriberId}")
	public ResponseEntity<List<BookingRequestDTO>> getPastBookingRequest(@PathVariable Long subscriberId){
		if(subscriberId != null) {
			List<BookingRequestDTO> requestDTOs = new ArrayList<>();
			List<BookingRequest> requests = bookingRequestService.getSubscriberPastBookingRequests(subscriberId);
			for (BookingRequest bookingRequest : requests) {
				requestDTOs.add(new BookingRequestDTO().toDto(bookingRequest));
			}
			return new ResponseEntity<>(requestDTOs, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
