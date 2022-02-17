package com.spring.myweb.util.interceptor;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.spring.myweb.command.UserVO;


public class BoardAuthHandler implements HandlerInterceptor {

	//화면에서 변경, 수정, 삭제가 일어날 때, writer값을 넘겨주도록 처리
	//게시글 수정, 삭제에 대한 권한 처리 핸들러
	//세션값과 writer(작성자) 정보가 같다면 컨트롤러를 실행,
	//그렇지 않다면 '권한이 없습니다.' 경고창 출력 후 뒤로가기.
	//권한이 없습니다 경고창은 jsp에서 했었던 PrintWriter 객체를 이용하시면 됩니다.
	//response객체의 getwriter로
	//PrintWriter 객체는 response 객체에게 받아 옵니다.

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("게시글 권한 인터셉터 동작!");
		String writer = request.getParameter("writer");
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("login");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		
		if(vo != null) {
			String loginUser = vo.getUserId();
			System.out.println("글 작성자: " + writer);
			System.out.println("로그인한 아이디: " + loginUser);
			
			if(writer.equals(loginUser)) {
				return true;
			} else {
				out.print("<script>alert('권한이 없습니다.'); history.back();</script>"); 
				out.flush();
				
				return false;
			}
			
		} else {
			out.print("<script>alert('권한이 없습니다.'); history.back();</script>"); 
			out.flush();
			
			return false;
		}
		
	}
}