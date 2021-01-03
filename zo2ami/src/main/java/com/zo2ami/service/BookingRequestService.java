package com.zo2ami.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.Activity;
import com.zo2ami.entity.BookingRequest;
import com.zo2ami.entity.User;
import com.zo2ami.enums.AccountType;
import com.zo2ami.repo.BookingRequestRepository;

@Service
public class BookingRequestService {

	@Autowired
	private BookingRequestRepository bookingRequestRepository;

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	public void addBookingRequest(Activity activity) {
		BookingRequest bookingRequest = new BookingRequest();
		bookingRequest.setActivity(activity);
		bookingRequest.setSubscriber(userDetailsService.getLoggedInUser());
		bookingRequest.setCreationDate(new Date());
		bookingRequest.setPaid(false);
		bookingRequest.setApproved(false);
		bookingRequestRepository.save(bookingRequest);
	}

	public BookingRequest findById(Long id) {
		Optional<BookingRequest> request = bookingRequestRepository.findById(id);
		return request.isPresent() ? request.get() : null;
	}

	public boolean canCancele(BookingRequest bookingRequest) {
		if (userDetailsService.getLoggedInUser().getAccountType().equals(AccountType.ADMIN)) {
			return true;
		}
		if (bookingRequest.getActivity() != null) {
			if (bookingRequest.getActivity().getLastBookingDate() != null)
				return bookingRequest.getActivity().getLastBookingDate().before(new Date());
			else
				return bookingRequest.getActivity().getStartDate().before(new Date());
		}
		return false;

	}

	public void cancelRequest(BookingRequest bookingRequest, String cancelReason) {
		User loggedInUser = userDetailsService.getLoggedInUser();
		if (loggedInUser.getAccountType().equals(AccountType.ADMIN)) {
			bookingRequest.setCancellationApproved(true);
		}
		bookingRequest.setCancelReson(cancelReason);
		bookingRequest.setCanceledBy(loggedInUser);
		bookingRequest.setCanceled(true);
		bookingRequest.setCancellationdate(new Date());

	}

	public void approveRequest(BookingRequest bookingRequest) {
		if(userDetailsService.getLoggedInUser().getAccountType().equals(AccountType.ADMIN)) {
			bookingRequest.setApproved(true);
			bookingRequestRepository.save(bookingRequest);
		}
		
	}

	public boolean canApprove() {
		return userDetailsService.getLoggedInUser().getAccountType().equals(AccountType.ADMIN);
	}
	
	public void approveCancellation(BookingRequest bookingRequest) {
		if(userDetailsService.getLoggedInUser().getAccountType().equals(AccountType.ADMIN))
			bookingRequest.setCancellationApproved(true);
		
	}

	public List<BookingRequest> getSubscriberCurrentBookingRequests(Long subscriberId) {
		return bookingRequestRepository.getSubscriberCurrentBookingRequests(subscriberId, new Date());
		
	}

}
