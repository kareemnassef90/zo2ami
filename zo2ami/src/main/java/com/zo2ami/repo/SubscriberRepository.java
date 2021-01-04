package com.zo2ami.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.zo2ami.entity.Subscriber;

public interface SubscriberRepository extends PagingAndSortingRepository<Subscriber, Long> {

}
