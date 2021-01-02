package com.zo2ami.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zo2ami.entity.BookingRequest;

@Repository
public interface BookingRequestRepository extends CrudRepository<BookingRequest, Long>{

	
	
}
