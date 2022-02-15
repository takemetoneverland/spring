package com.spring.mvc.board;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/servlet-config.xml",
"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
@WebAppConfiguration
@Log4j //log를 찍는 도구. 따로 파일로 받을 수 있고 정보를 넣을 수 있다.
public class BoardControllerTest {

	//테스트 환경에서 가상의 DispatcherServlet을 사용하기 위한 객체 자동 주입.
	//WebApplicationContext는 Spring에서 제공되는 servlet들을 사용할 수 있도록
	//정보를 저장하는 객체이다.
	@Autowired
	private WebApplicationContext ctx;

	//	@Autowired
	//	private BoardController controller;

	//MockMvc는 웹 어플리케이션을 서버에 배포하지 않아도 스프링 MVC 동작을
	//구현할 수 있는 가상의 구조를 만들어 준다.
	private MockMvc mockMvc;

	@Before //test module에서는 junit의 before를 import test메서드가 실행되기 전에 미리 동작
	public void setUp() {
		//가상 구조를 세팅
		//스프링 컨테이너에 등록된 모든 빈과 의존성 주입까지 로드해서 사용이 가능.
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();

		//테스트할 컨트롤러를 수동으로 주입. 하나의 컨트롤러만 테스트를 진행할 때 이렇게 쓴다.
		//		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testList() throws Exception { //예외를 던져줌
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				); //console창에 출력. setviewname(): 목적지
	}

	@Test
	public void testInsert() throws Exception {
		String viewPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/write")
											.param("title", "테스트 새 글 제목")
											.param("content", "테스트 새 글 내용")
											.param("writer", "user01")
											).andReturn().getModelAndView().getViewName();
		log.info(viewPage);
	}

	//게시글 상세보기 요청 넣어보기.
	//컨트롤러에서는 DB에서 가지고 온 글 객체를 model에 담아서 jsp로 이동시킬 것입니다.
	//42번글을 보여달라는 요청을 넣으시고, 요청 결과가 들어있는 model을 출력해 보세요.
	// /board/content -> get
	@Test
	public void testContent() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/content")
						.param("boardNo", "42")
						).andReturn().getModelAndView().getModelMap()
				);
	}

	//5번글의 제목과 내용을 수정하는 요청을 보낼 예정입니다.
	//전송방식은 post 방식입니다.
	//수정 후 이동하는 페이지는 해당 글의 상세보기 페이지입니다.
	//컨트롤러가 리턴하는 viewName을 출력해 주세요. ("/board/modify") 제목과 내용만. 작성자는 수정x

	//42번글을 삭제하세요.
	//전송 방식은 post방식이고, 이동하는 곳은 목록 요청이 재요청될 것입니다.
	//viewName을 출력해 주세요.
	@Test
	public void testRemove() throws Exception {
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.post("/board/delete")
						.param("boardNo", "42")
						).andReturn().getModelAndView().getViewName()
				);
		
	}
	
}