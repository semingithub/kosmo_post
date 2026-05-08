package com.semin.app.aop.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootTest
public class MemberTest {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	void setPassword() throws Exception{
		String s = passwordEncoder.encode("1234");
		System.out.println(s);
	}

}
