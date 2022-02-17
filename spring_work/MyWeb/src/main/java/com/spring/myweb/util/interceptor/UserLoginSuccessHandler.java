package com.spring.myweb.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.spring.myweb.command.UserVO;

public class UserLoginSuccessHandler implements HandlerInterceptor {

	//로그인 처리 이후에 시행되는 핸들러 (postHandle) 오버라이딩
	//1. /login 요청으로 들어올 때 실행되도록 xml 파일에 빈으로 등록 후 매핑.
	
	@Override //오버라이딩은 메서드 이름, 매개변수, 리턴타입이 같아야 함. 접근제한자는 부모와 같거나 넓어야 함.
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("로그인 인터셉터 동작!");
		
		//modelAndView 객체에 있는 모델 데이터가 map의 형식으로 반환.
		ModelMap mv = modelAndView.getModelMap(); //컨트롤러가 모델에 넣었던 값을 꺼내오려고.
		UserVO vo = (UserVO) mv.get("user");
		System.out.println("interceptor vo: " + vo);
		
		if(vo != null) { //컨트롤러에서 로그인을 성공했던 사람.
			System.out.println("로그인 성공 로직 동작!");
			//로그인 성공한 회원에게 세션 데이터를 생성해서 로그인 유지를 하게 해 줌.
			HttpSession session = request.getSession();
			session.setAttribute("login", vo);
			response.sendRedirect(request.getContextPath());
		} else { //vo == null -> 로그인 실패
			System.out.println("로그인 실패 로직 동작!");
			modelAndView.addObject("msg", "loginFail");
//			modelAndView.setViewName("/user/userLogin");
		}
		
	}
	
}