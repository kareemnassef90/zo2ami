package com.zo2ami.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.zo2ami.entity.ServiceProvider;

@Repository
public interface ServiceProviderRepository extends PagingAndSortingRepository<ServiceProvider, Long> {

}
