package com.zo2ami.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zo2ami.entity.SystemSettings;
import com.zo2ami.repo.SystemSettingsRepository;

@Service
public class SystemSettingsService {

	@Autowired
	SystemSettingsRepository systemSettingsRepository ;
	
	
	public SystemSettings getSystemSettings(){
		Optional<SystemSettings>  settings = systemSettingsRepository.findById(1l);
		if(settings.isPresent())
			return settings.get();
		else
			return new SystemSettings();
	}
	
}
