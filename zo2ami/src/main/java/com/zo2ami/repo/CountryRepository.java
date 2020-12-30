package com.zo2ami.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zo2ami.entity.Country;


@Repository
public interface CountryRepository extends CrudRepository<Country, Long>{
	
	List<Country> findAll();

}
