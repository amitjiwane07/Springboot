package com.example.demo.serviceImple;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.FileService;
@Service
public class FileServiceImple implements FileService{

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {

		//File Name
		String name=file.getOriginalFilename();
		
		//This is we implement to generate random iD because if we save same image name then it will generate error thats why
		//Rename
		String randomId=UUID.randomUUID().toString();
		String fileName1=randomId.concat(name.substring(name.lastIndexOf(".")));
		
		//full path
		String filePath=path+File.separator+fileName1;
		
		//Created folder if not created
		File f=new File(path);
		if(!f.exists()) {
			f.mkdir(); //it will create folder
		}
		
		//file copy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		return name;
	} 
	
}
