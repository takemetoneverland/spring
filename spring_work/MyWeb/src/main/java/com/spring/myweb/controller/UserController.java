package com.spring.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myweb.command.UserVO;
import com.spring.myweb.user.service.IUserService;
import com.spring.myweb.util.MailSendService;

@Controller //빈 등록 하기 위해서 붙이는 아노테이션
@RequestMapping("/user") //공통 URL mapping
public class UserController {

	@Autowired //주입
	private IUserService service;
	@Autowired
	private MailSendService mailService;
	
	//회원가입 페이지 이동
	@GetMapping("/userJoin")
	public void userJoin() {}
	
	//아이디 중복 확인(비동기)
	@ResponseBody //Rest Controller가 아닌 경우에는 아노테이션을 붙여야 비동기 통신이 가능하다.
	@PostMapping("/idCheck")
	public String idCheck(@RequestBody String userId) {
		int result = service.idCheck(userId);
		if(result == 1) {
			return "duplicated";
		} else {
			return "ok";
		}
	}
	
	//이메일 인증
	@GetMapping("/mailCheck")
	@ResponseBody //결과를 바로 리턴할 것이여서 붙임
	public String mailCheck(String email) { //@RequestBody는 JSON방식의 경우 사용해야하는데 여기서는 필요없음. url에 붙여 옴 @RequestParam은 생략 가능해서 안썼음 (변수이름 동일)
		System.out.println("이메일 인증 요청이 들어옴!");
		System.out.println("인증 이메일: " + email);
		return mailService.joinEmail(email);
	}
	
	//회원 가입 처리
	@PostMapping("/join")
	public String join(UserVO vo, RedirectAttributes ra) {
		service.join(vo);
		ra.addFlashAttribute("msg", "joinSuccess");
		return "redirect:/user/userLogin";
	}
	
	//로그인 페이지 이동 요청
	@GetMapping("/userLogin")
	public void userLogin() {}
	
	//로그인 요청
	@PostMapping("/login")
	public String login(String userId, String userPw, Model model) { //@RequestParam 생략함
		UserVO vo = service.login(userId, userPw);
		model.addAttribute("user", vo);
		return "/user/userLogin";
		/*
		 주석 작성한 내용을 컨트롤러가 아닌 인터셉터에서 처리.
		 if(vo != null) {
		 	model.addAttribute("vo", vo);
		 	session.setAttribute("login", vo);
		 	return "redirect:/";
	 	 } else {
	 	 	ra.addFlashAttribute("msg", "loginFail");
	 	 	return "redirect:/user/userLogin";
 	 	 }
		 */
	}
	
	//마이페이지 이동 요청
	@GetMapping("/userMyPage")
	public void userMyPage(HttpSession session, Model model) {
		
		//세션 데이터에서 id를 뽑아야 sql문을 돌릴 수 있다.
		String id = ((UserVO)session.getAttribute("login")).getUserId();
		
		UserVO userInfo = service.getInfo(id);
		model.addAttribute("userInfo", userInfo);
	}
	
	//수정 로직
	@PostMapping("/userUpdate")
	public String userUpdate(UserVO vo, RedirectAttributes ra) {
		System.out.println("param: " + vo);
		service.updateUser(vo);
		
		ra.addFlashAttribute("msg", "수정이 완료되었습니다.");
		return "redirect:/";
	}
	
}














