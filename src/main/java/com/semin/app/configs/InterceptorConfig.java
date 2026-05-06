package com.semin.app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.semin.app.interceptors.LoginCheckInterceptor;
import com.semin.app.interceptors.WriterCheckInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	
	@Autowired
	private LoginCheckInterceptor loginCheckInterceptor;
	
	@Autowired
	private WriterCheckInterceptor writerCheckInterceptor;
	
	@Autowired
	private LocaleChangeInterceptor localeChangeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//적용할 Interceptor등록
		// Interceptor를 사용할 URL 패턴 작성, addPathPatterns 여러번 호출 가능
		// Interceptor를 제외할 URL 패턴 작성, excludePathPatterns 여러번 호출 가능

		
		// member로 시작하는 모든 URL /  login, join은 제외
		// qna list를 제외한 나머지들은 회원만 사용가능
		registry.addInterceptor(loginCheckInterceptor)
		.addPathPatterns("/member/*", "/qna/*", "/board/update")
		.excludePathPatterns("/member/login", "/member/join", "/qna/list");
		
		registry.addInterceptor(writerCheckInterceptor)
		.addPathPatterns("/board/update", "/qna/update");
		
		registry.addInterceptor(localeChangeInterceptor)
		.addPathPatterns("/**");
		
	}

}
