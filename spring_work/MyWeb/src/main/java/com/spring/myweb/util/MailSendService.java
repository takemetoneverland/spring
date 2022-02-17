package com.spring.myweb.util;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailSendService {

	@Autowired
	private JavaMailSender mailSender;
	private int authNum; //인증번호 -> 컨트롤러로 리턴
	
	//난수 발생 (마음대로 작성)
	public void makeRandomNumber() {
		//난수의 범위: 111111 ~ 999999
		Random r = new Random();
		int checkNum = r.nextInt(888888) + 111111;
		System.out.println("인증번호: " + checkNum);
		authNum = checkNum;
	}
	
	//회원 가입 시 사용할 이메일 양식
	public String joinEmail(String email) {
		makeRandomNumber();
		String setFrom = "122bittersweet@gmail.com"; //email-config에 설정한 자신의 이메일 주소를 입력.
		String toMail = email; //수신받을 이메일
		String title = "회원 가입 인증 이메일 입니다."; //이메일 제목
		//이메일 내용 html형식으로 작성
		String content = "홈페이지를 방문해주셔서 감사합니다." +
				"<br><br>" + 
				"인증 번호는 " + authNum + "입니다." + //인증 번호는 난수로 만들것임
				"<br>" + 
				"해당 인증번호를 인증번호 확인란에 기입하여 주세요."; //이메일 내용 삽입
		mailSend(setFrom, toMail, title, content);
		return Integer.toString(authNum); //컨트롤러로 난수 리턴
	}

	//비밀번호 찾기 할 때 사용할 이메일 양식
	public void findPwEmail() {
		
	}

	//이메일 전송 메서드
	public void mailSend(String setFrom, String toMail, String title, String content) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			//true 매개값을 전달하면 MultiPart 형식의 메세지 전달이 가능. MultiPart: 다중 이미지, 영상 같은 것들. 문자 인코딩 설정도 가능.
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			//true전달 -> html형식으로 전송, 작성하지 않으면 단순 텍스트로 전달.
			helper.setText(content, true);
			mailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}