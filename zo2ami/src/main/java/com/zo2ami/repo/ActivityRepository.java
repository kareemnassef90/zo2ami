package com.zo2ami.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.zo2ami.entity.Activity;

@Repository
public interface ActivityRepository extends PagingAndSortingRepository<Activity, Long>{
	
	
	@Query(value = "SELECT a.* FROM activity a\n" + 
			"inner join activity_category ac ON a.id = ac.activity_id \n" +
			"WHERE ac.category_id=:categoryId", nativeQuery = true)
	public List<Activity>findAllByCategoryId(Long categoryId);
	
	@Query(value = "select * from activity where last_booking_date >= CURDATE() ", nativeQuery = true)
	public Page<Activity>findAvailableActivities(Pageable page);
	
}
