package com.spring.mvc.user.commons.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.repository.IUserMapper;

public class AutoLoginInterceptor implements HandlerInterceptor {
	
	@Autowired
	private IUserMapper mapper;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("자동 로그인 인터셉터 발동!");
		
		//1. 자동 로그인 쿠키가 있는지의 여부 확인.
		//-> loginCookie의 존재 여부를 확인
		//원하는 쿠키의 값을 한방에 꺼내올 수 있다. (request객체, 쿠키이름)
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		
		//자동 로그인 신청한 사람이라면 로그인 유지를 위해 세션 데이터를 만들어 줘야지~
		HttpSession session = request.getSession();
		if(loginCookie != null) { //자동 로그인을 이전에 신청한 유저구나~
			
			//2. DB에서 쿠키값(세션ID)과 일치하는 세션ID를 가진 회원의 정보를 조회
			UserVO vo = mapper.getUserWithSessionId(loginCookie.getValue());
			System.out.println("쿠키의 값: " + loginCookie.getValue());
			System.out.println("DB에서 가지고 온 값: " + vo);
			if(vo != null) {
				//자동 로그인 신청한 사람의 로그인 데이터(세션)를 만들어 주자.
				session.setAttribute("login", vo);
				System.out.println("세션 제작 완료!");
			}
		}
		
		//true이면 컨트롤러로 요청이 들어가고, false면 요청을 막는다.
		//자동 로그인 신청 여부와 상관없이 홈 화면은 무조건 봐야 하니까 true를 작성한다.
		return true;
	}

}









