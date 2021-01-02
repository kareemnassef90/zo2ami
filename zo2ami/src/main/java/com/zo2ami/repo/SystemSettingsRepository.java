package com.zo2ami.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zo2ami.entity.SystemSettings;

@Repository
public interface SystemSettingsRepository extends CrudRepository<SystemSettings, Long>{
	
}
