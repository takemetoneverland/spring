package com.spring.myweb.user.service;

import org.apache.ibatis.annotations.Param;

import com.spring.myweb.command.UserVO;

public interface IUserService {

	//아이디 중복 확인
	int idCheck(String id);

	//회원 가입
	void join(UserVO vo);

	//로그인
	// IUsermapper 붙여넣기 했는데 @Param("pw")은 마이바티스 아노테이션이라 service에서는 필요없어서 지움
	UserVO login(@Param("id") String id, @Param("pw")String pw); 

	//회원 정보 얻어오기(마이페이지용)
	UserVO getInfo(String id);

	//회원 정보 수정
	void updateUser(UserVO vo);

	//회원 정보 삭제
	void deleteUser(@Param("id") String id, String pw);

}
