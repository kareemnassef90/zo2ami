package com.zo2ami.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	
	@Autowired
	SystemSettingsService systemSettingsService;
	
	
	private void saveUploadedFiles(List<MultipartFile> files, String folder) throws IOException {

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(systemSettingsService.getSystemSettings().getFilesUploadingPath() + folder + file.getOriginalFilename());
            Files.write(path, bytes);

        }

    }

}
