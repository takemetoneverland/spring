package com.spring.myweb.freeboard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.myweb.command.FreeBoardVO;
import com.spring.myweb.freeboard.mapper.IFreeBoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/db-config.xml") //xml이 하나일때는 locations 생략 가능하다.
public class FreeBoardMapperTest {
	
	@Autowired
	private IFreeBoardMapper mapper;
	
	@Test
	public void registTest() {
		for(int i=1; i<=30; i++) {
			FreeBoardVO vo = new FreeBoardVO();
			vo.setTitle("테스트 글쓰기 " + i);
			vo.setWriter("asdf1234");
			vo.setContent("테스트 글쓰기 내용입니다. " + i);
			mapper.regist(vo);
		}
	}

}