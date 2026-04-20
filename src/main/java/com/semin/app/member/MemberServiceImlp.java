package com.semin.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.semin.app.file.FileManager;

@Service
public class MemberServiceImlp implements MemberService {

	@Value("${app.member}")
	private String name;

	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private FileManager fileManager;

	@Override
	public int join(MemberDTO memberDTO, MultipartFile file) throws Exception {
		// DB에 저장
		int result = memberMapper.join(memberDTO);

		// profile 이미지를 HDD에 저장
		if (file != null && !file.isEmpty()) {
			String fileName = fileManager.fileSave(name, file);

			// 저장된 정보를 DB에 저장
			ProfileDTO profileDTO = new ProfileDTO();
			profileDTO.setFileName(fileName);
			profileDTO.setOriName(file.getOriginalFilename());
			profileDTO.setUsername(memberDTO.getUsername());

			result = memberMapper.addProfile(profileDTO);
		}

		return result;
	}
	
	@Override
	public MemberDTO detail(MemberDTO memberDTO) throws Exception {
		MemberDTO check = memberMapper.detail(memberDTO);
		
		if(check != null) {
			if(check.getPassword().equals(memberDTO.getPassword())) {
				return check;
			}
			
			return null;
		}
		
		return check;
	}
}
