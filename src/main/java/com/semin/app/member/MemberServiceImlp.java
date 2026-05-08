package com.semin.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.semin.app.file.FileManager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberServiceImlp implements MemberService, UserDetailsService {

	@Value("${app.member}")
	private String name;

	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUsername(username);
		memberDTO = memberMapper.detail(memberDTO);
		log.info("{}", memberDTO);
		return memberMapper.detail(memberDTO);
	}	
	
	@Override
	public int update(MemberDTO memberDTO) throws Exception {
		return memberMapper.update(memberDTO);
	}

	// 사용자 정의 검증 메서드
	public boolean doubleCheck(MemberDTO memberDTO, BindingResult bindingResult) throws Exception {
		// false: 통과, true: 실패
		boolean result = false;

		// annotation으로 검증한 결과 담기
		result = bindingResult.hasErrors();

		// password가 일치하는지 검증
		if (!memberDTO.getPassword().equals(memberDTO.getPasswordCheck())) {
			bindingResult.rejectValue("passwordCheck", "member.passwordCheck.notEqual");
			result = true;
		}

		Object obj = memberMapper.detail(memberDTO);
		if (obj != null) {
			result = true;
			bindingResult.rejectValue("username", "member.username.equal");
		}

		return result;
	}

	@Override
	public int join(MemberDTO memberDTO, MultipartFile file) throws Exception {
		// DB에 저장
		memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
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

		if (check != null) {
			if (check.getPassword().equals(memberDTO.getPassword())) {
				return check;
			}

			return null;
		}

		return check;
	}

	@Override
	public MemberDTO idCheck(MemberDTO memberDTO) throws Exception {

		return memberMapper.detail(memberDTO);
	}

}
