package com.semin.app.file;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	@Value("${app.upload.base}")
	private String path;

	public String fileSave(String name, MultipartFile mf) throws Exception {
		// 1. 저장 위치
		File file = new File(path, name);
		if (!file.exists()) {
			file.mkdirs();
		}

		// 2. 파일명, 확장자
		String fileName = UUID.randomUUID().toString();
		fileName = fileName + "_" + mf.getOriginalFilename();

		file = new File(file, fileName);
		
		// 3. 저장
		// a. MultipartFile의 transferTo 메서드
//		mf.transferTo(file);
		// b. FileCopyUtils의 copy 메서드
		FileCopyUtils.copy(mf.getBytes(), file);
		
		return fileName;

	}

}
