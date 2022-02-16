package com.spring.myweb.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.myweb.command.UserVO;
import com.spring.myweb.user.mapper.IUserMapper;

@Service //서비스 등록 아노테이션
public class UserService implements IUserService {

	@Autowired
	private IUserMapper mapper;
	
	@Override
	public int idCheck(String id) {
		return mapper.idCheck(id);
	}

	@Override
	public void join(UserVO vo) {
		mapper.join(vo);
	}

	@Override
	public UserVO login(String id, String pw) { //IUserMapper에서 2개 처리해놨음.
		return mapper.login(id, pw);
	}

	@Override
	public UserVO getInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(UserVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String id, String pw) {
		// TODO Auto-generated method stub

	}

}
