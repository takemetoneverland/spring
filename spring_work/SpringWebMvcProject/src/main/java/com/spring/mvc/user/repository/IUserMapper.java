package com.spring.mvc.user.repository;

import java.util.Map;

import com.spring.mvc.user.model.UserVO;

public interface IUserMapper {

	//아이디 중복 체크 기능
	int checkId(String account);
	
	//회원 가입 기능
	void register(UserVO user);
	
	//회원 정보 조회 기능
	UserVO selectOne(String account);

	//회원 탈퇴 기능
	void delete(String account);
	
	//자동 로그인 쿠키값 DB 저장 처리.
	//SQL -> INSERT??? UPDATE!
	void keepLogin(Map<String, Object> datas);
	
	//세션 아이디를 통한 회원 정보 조회 기능
	/*
	 자동 로그인 하고 싶다는 사람한테 뭘 만들어 줬죠? -> 쿠키(세션id)
	 그리고 나서 그 사람이 나중에 우리 사이트에 다시 방문했다고 치자.
	 당연히 우리 서버에 요청을 보낼 거고, 요청과 함께 쿠키도 같이 전달이 되겠죠?
	 우리는 쿠키 안에 들어있는 세션 id로 회원 정보를 조회해서 마치 이 사람이 로그인 중인 것처럼
	 세션 데이터를 만들어 주자. (login이라는 세션 데이터 -> 로그인 중이라는 징표) 
	 */
	UserVO getUserWithSessionId(String sessionId);
	
}










