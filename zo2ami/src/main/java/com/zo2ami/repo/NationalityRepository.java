package com.zo2ami.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zo2ami.entity.Nationality;


@Repository
public interface NationalityRepository extends CrudRepository<Nationality, Long>{
	
	List<Nationality> findAll();

}
