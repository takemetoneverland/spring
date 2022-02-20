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
		
		System.out.println("게시판 권한 인터셉터 발동!");
		
		String writer = request.getParameter("writer");
		HttpSession session = request.getSession(); //지금 로그인한 사용자의 아이디를 받아오려고.
		UserVO vo = (UserVO) session.getAttribute("login");
		
		System.out.println("화면에서 넘어오는 값: " + writer);
		System.out.println("세션에 저장된 값: " + vo);
		
		
		if(vo != null) {
			if(writer.equals(vo.getUserId())) {
				return true; //컨트롤러로 요청의 진입을 허용
			} 
		} 
			
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); //원래 예외처리 해야하는데, 메서드 자체에 예외처리가 되어있어서 예외처리 필요 없음
		out.print("<script> \r\n"); 
		out.print("alert('권한이 없습니다.'); \r\n"); 
		out.print("history.back(); \r\n"); 
		out.print("</script>");
		
		out.flush();
			
		return false;
		
	}
}