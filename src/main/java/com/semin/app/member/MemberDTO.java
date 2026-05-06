package com.semin.app.member;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {

	@NotBlank(groups = GroupAdd.class, message = "아이디를 입력하세요")
	private String username;
	@NotBlank(groups = { GroupAdd.class, GroupUpdate.class })
	private String name;
	@NotBlank(groups = GroupAdd.class, message = "비밀번호를 입력하세요")
	@Size(groups = GroupAdd.class, max = 16, min = 4)
	private String password;
	private String passwordCheck;
	private String phone;
	@Email(groups = { GroupAdd.class, GroupUpdate.class })
	private String email;
	@Past(groups = { GroupAdd.class, GroupUpdate.class })
	private LocalDate birth;

	private ProfileDTO profileDTO;

}
