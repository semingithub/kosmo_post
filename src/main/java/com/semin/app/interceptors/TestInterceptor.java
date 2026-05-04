package com.semin.app.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TestInterceptor implements HandlerInterceptor {

	// Controller 들어오기 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// return이 true면 Controller로 진행
		// return이 false면 Controller로 진행을 막음
		System.out.println("Pre Handle");
		return true;
	}

	// Controller에서 빠져 나갈 때
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Post Handle");
	}

	// JSP에서 HTML로 랜더링 후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("After");
	}

}
