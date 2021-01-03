package com.zo2ami.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zo2ami.entity.Activity;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long>{
	
	
	@Query(value = "SELECT a.* FROM activity a\n" + 
			"inner join activity_category ac ON a.id = ac.activity_id \n" +
			"WHERE ac.category_id=:categoryId", nativeQuery = true)
	public List<Activity>findAllByCategoryId(Long categoryId);
	
	@Query(value = "select * from activity where start_date < CURDATE()", nativeQuery = true)
	public List<Activity>findAvailableActivities();
	
}
