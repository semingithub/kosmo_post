package com.semin.app.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// 정적 자원
	@Bean
	WebSecurityCustomizer customizer() {
		return web -> {
			web.ignoring()
			.requestMatchers("/css/**", "/images/**", "/img/**", "/js/**", "/vendor/**")
			.requestMatchers("/files/**", "/fileDown/**");
		};
	}
	
	// 인증과 인가의 대한 설정
	@Bean
	SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		
		security
		.cors(cors -> {
			cors.disable();
		})
		.csrf(csrf -> {
			csrf.disable();
		})
		.authorizeHttpRequests(auth -> {
			auth
			.requestMatchers("/board/create", "/board/update", "/board/delete").hasRole("ADMIN")
			.requestMatchers("/qna/create", "/qna/detail", "/qna/update", "/qna/delete").hasRole("MEMBER")
			.requestMatchers("/product/create", "/product/update", "/product/delete").hasAnyRole("ADMIN", "MANAGER")
			.requestMatchers("/member/mypage", "/member/logout", "/member/update").authenticated()
			.anyRequest().permitAll()
//			.anyRequest().denyAll()
			;
		})
		// Login form과 관련된 설정
		.formLogin(form -> {
			form
			.loginPage("/member/login")
			.usernameParameter("username")
			.passwordParameter("password")
			.loginProcessingUrl("/member/login")
			.defaultSuccessUrl("/")
			.failureUrl("/")
			;
		})
		.logout(logout -> {
			logout
			.logoutUrl("/member/logout")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.logoutSuccessUrl("/");
		});
		
		return security.build();
	}
	
}
