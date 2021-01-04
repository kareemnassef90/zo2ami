package com.zo2ami.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {
	
	private static final Logger LOGGER = LogManager.getLogger(StorageService.class);
	
	@Autowired
	private SystemSettingsService systemSettingsService;
	
	static final String SERVICE_PROVIDER_LEGAL_DOCS_PATH = "/service_provider/legal_docs/";
	static final String SERVICE_PROVIDER_PROFILE_PIC_PATH = "/service_provider/profile_pic/";
	
	static final String SUBSCRIBER_CERTS_PATH = "/subscriber/certs/";
	static final String SUBSCRIBER_PROFILE_PIC_PATH = "/subscriber/profile_pic/";
	
	static final String ACTIITY_PIC_PATH = "/actiivity/pic/";
	
	static final String SEPARATOR = "/";
	
	/****************************************** UPLOAD ****************************************/
	public void saveServiceProviderLegalDocs(List<MultipartFile> files, Long serviceProviderId) {
		String mainPath = systemSettingsService.getSystemSettings().getFilesUploadingPath();
		saveUploadedFiles(files, mainPath + SERVICE_PROVIDER_LEGAL_DOCS_PATH + serviceProviderId + SEPARATOR);
	}
	
	public void saveServiceProviderProfilePic(MultipartFile file, Long serviceProviderId) {
		String mainPath = systemSettingsService.getSystemSettings().getFilesUploadingPath();
		saveUploadedFile(file, mainPath + SERVICE_PROVIDER_PROFILE_PIC_PATH + serviceProviderId + SEPARATOR);
	}
	
	public void saveSubscriberCerts(List<MultipartFile> files, Long subscriberId) {
		String mainPath = systemSettingsService.getSystemSettings().getFilesUploadingPath();
		saveUploadedFiles(files, mainPath + SUBSCRIBER_CERTS_PATH + subscriberId + SEPARATOR);
	}
	
	public void saveSubscriberProfilePic(MultipartFile file, Long subscriberId) {
		String mainPath = systemSettingsService.getSystemSettings().getFilesUploadingPath();
		saveUploadedFile(file, mainPath + SUBSCRIBER_PROFILE_PIC_PATH + subscriberId+ SEPARATOR);
	}
	
	public void saveActivityPics(List<MultipartFile> files, Long activityId) {
		String mainPath = systemSettingsService.getSystemSettings().getFilesUploadingPath();
		saveUploadedFiles(files, mainPath + ACTIITY_PIC_PATH + activityId + SEPARATOR);
	}
	
	
	/****************************************** LINKS ****************************************/
	
	public List<String> getServiceProviderFilesPaths(Long serviceProviderId) {
		String mainPath = systemSettingsService.getSystemSettings().getFilesUploadingPath();
		return getFilesNamesinPath(mainPath + SERVICE_PROVIDER_LEGAL_DOCS_PATH + serviceProviderId + SEPARATOR);
	}
	
	public String getServiceProviderProfilePicPath(Long serviceProviderId) {
		String mainPath = systemSettingsService.getSystemSettings().getFilesUploadingPath();
		List<String> profilePicPath = getFilesNamesinPath(mainPath + SERVICE_PROVIDER_PROFILE_PIC_PATH + serviceProviderId + SEPARATOR);
		if(!profilePicPath.isEmpty())
			return profilePicPath.get(0);
		else return "";
	}
	
	public List<String> getSubscriberCertsPaths(Long subscriberId) {
		String mainPath = systemSettingsService.getSystemSettings().getFilesUploadingPath();
		return getFilesNamesinPath(mainPath + SUBSCRIBER_CERTS_PATH + subscriberId + SEPARATOR);
	}
	
	public String getSubscriberProfilePicPath(Long subscriberId) {
		String mainPath = systemSettingsService.getSystemSettings().getFilesUploadingPath();
		List<String> profilePicPath = getFilesNamesinPath(mainPath + SUBSCRIBER_PROFILE_PIC_PATH + subscriberId + SEPARATOR);
		if(!profilePicPath.isEmpty())
			return profilePicPath.get(0);
		else return "";
	}
	
	
	public List<String> getActiviytPicsPaths(Long activityId) {
		String mainPath = systemSettingsService.getSystemSettings().getFilesUploadingPath();
		return getFilesNamesinPath(mainPath + ACTIITY_PIC_PATH + activityId + SEPARATOR);
	}
	
	
	
	
	
	private void saveUploadedFiles(List<MultipartFile> files, String uploadFolder) {

		for (MultipartFile file : files) {

			if (file.isEmpty()) {
				continue;
			}

			byte[] bytes;
			try {
				bytes = file.getBytes();
				Path path = Paths.get(uploadFolder + file.getOriginalFilename());
				Files.write(path, bytes);
			} catch (IOException e) {
				LOGGER.error("ERROR WHILE SAVING FILE : {} IN PATH : {}  : {}", file.getOriginalFilename(),
						uploadFolder, e);
			}

		}

	}
	
	private void saveUploadedFile(MultipartFile file, String uploadFolder) {
		byte[] bytes;
		try {
			bytes = file.getBytes();
			Path path = Paths.get(uploadFolder + file.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e) {
			LOGGER.error("ERROR WHILE SAVING FILE : {} IN PATH : {}  : {}", file.getOriginalFilename(), uploadFolder,
					e);
		}

	}

	private List<String> getFilesNamesinPath(String path) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		List<String> filesPaths = new ArrayList<>();
		for (int i = 0; i < listOfFiles.length; i++) {
			filesPaths.add(listOfFiles[i].getName());
		}
		return filesPaths;
	}
	
	
	

}
