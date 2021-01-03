package com.zo2ami.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zo2ami.entity.BookingRequest;

@Repository
public interface BookingRequestRepository extends CrudRepository<BookingRequest, Long>{


	@Query(value = "SELECT br.* FROM booking_request br \n" + 
			"INNER JOIN activity a ON a.id = br.activity_id\n" + 
			"WHERE br.subscriber_id =:subscriberId AND a.end_date < :CurrentDate ", nativeQuery = true)
	public List<BookingRequest>getSubscriberCurrentBookingRequests(Long subscriberId, Date CurrentDate);
	
	
	@Query(value = "SELECT br.* FROM booking_request br \n" + 
			"INNER JOIN activity a ON a.id = br.activity_id\n" + 
			"WHERE br.subscriber_id =:subscriberId AND a.end_date > :CurrentDate ", nativeQuery = true)
	public List<BookingRequest>getSubscriberPastBookingRequests(Long subscriberId, Date CurrentDate);
	
}
