package com.semin.app.configs;

import com.semin.app.member.MemberServiceImlp;
import com.semin.app.security.AddLogout;
import com.semin.app.security.AddLogoutHandler;
import com.semin.app.security.LoginFailHandler;
import com.semin.app.security.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final MemberServiceImlp memberServiceImlp;
	private final AddLogoutHandler addLogoutHandler;
	private final AddLogout addLogout;
	private final LoginFailHandler loginFailHandler;
	private final LoginSuccessHandler loginSuccessHandler;

	SecurityConfig(LoginSuccessHandler loginSuccessHandler, LoginFailHandler loginFailHandler, AddLogout addLogout, AddLogoutHandler addLogoutHandler, MemberServiceImlp memberServiceImlp) {
		this.loginSuccessHandler = loginSuccessHandler;
		this.loginFailHandler = loginFailHandler;
		this.addLogout = addLogout;
		this.addLogoutHandler = addLogoutHandler;
		this.memberServiceImlp = memberServiceImlp;
	}

	// 정적 자원
	@Bean
	WebSecurityCustomizer customizer() {
		return web -> {
			web.ignoring()
			.requestMatchers("/css/**", "/images/**", "/img/**", "/js/**", "/vendor/**")
			.requestMatchers("/files/**", "/fileDown/**");
		};
	}
	
//	@Bean
//	public SessionRegistry sessionRegistry() {
//	    return new SessionRegistryImpl();
//	}
//	
//    @Bean
//    public HttpSessionEventPublisher httpSessionEventPublisher() {
//        return new HttpSessionEventPublisher();
//    }
	
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
//			.defaultSuccessUrl("/")
			.successHandler(loginSuccessHandler)
//			.failureUrl("/")
			.failureHandler(loginFailHandler)
			;
		})
		.logout(logout -> {
			logout
			.logoutUrl("/member/logout")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
//			.logoutSuccessUrl("/")
			.addLogoutHandler(addLogout)
			.logoutSuccessHandler(addLogoutHandler)
			;
			
		})
		.rememberMe(remember -> {
			remember
			.rememberMeParameter("rememberMe")
			.key("rememberKey")
			.tokenValiditySeconds(60*60*24*7)
			.userDetailsService(memberServiceImlp)
			.authenticationSuccessHandler(loginSuccessHandler)
			.useSecureCookie(true)
			;
		})
		.sessionManagement(session -> {
			session
			.maximumSessions(1)
			.maxSessionsPreventsLogin(true)
			.expiredUrl("/member/login")
//			.and()
//			.sessionFixation().changeSessionId()
//			.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
			;
		})
		;
		
		return security.build();
	}
	
}
