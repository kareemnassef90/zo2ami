package com.zo2ami.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zo2ami.entity.Residence;

@Repository
public interface ResidenceRepository extends CrudRepository<Residence, Long>{
	
	List<Residence>findAllByCountryId(long countryId );
	

}
