package com.semin.app.aop.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Card {

	// execution(접근지정자, 패키지명.클래스명)
	@Around("execution(* com.semin.app.aop.test.Transport.take*(..))")
	public Object cardCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("승차 Card Check");

		Object[] ar = proceedingJoinPoint.getArgs();
		
		log.info("{}", ar);

		Object obj = proceedingJoinPoint.proceed();
		
		log.info("return: {}", obj);

		System.out.println("하차 Card Check");

		return obj;
	}

}
