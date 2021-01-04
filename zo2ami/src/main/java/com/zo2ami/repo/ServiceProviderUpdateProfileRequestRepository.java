package com.zo2ami.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zo2ami.entity.ServiceProviderUpdateProfileRequest;

@Repository
public interface ServiceProviderUpdateProfileRequestRepository extends CrudRepository<ServiceProviderUpdateProfileRequest, Long>{

	
	public Page<ServiceProviderUpdateProfileRequest> findByApprovedTrue(Pageable page);
}
