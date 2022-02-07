package com.spring.mvc.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.repository.IBoardMapper;

@RunWith(SpringJUnit4ClassRunner.class) //test 가상환경을 만들어주는 객체
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
//mapper가 잘 작동되는지 mvc-config.xml에 있는 설정들 가져오겠다. 이게 없으면 주입이 안됨. main이 아니라서 자동 적용이 안된다.
public class BoardMapperTest {

	@Autowired //mvc-config.xml을 끌어오기 때문에 Autowired가 가능함
	private IBoardMapper mapper; //IBoardMapper 인터페이스 타입의 객체가 필요함
	
	//게시글 등록 단위 테스트
	@Test
	public void insertTest() {
		for(int i=1; i<=300; i++) {
			BoardVO article = new BoardVO();
			article.setTitle("테스트 제목입니다." + i);
			article.setWriter("김테스트" + i);
			article.setContent("테스트 중이니까 조용히 하세요!" + i);
			mapper.insert(article);
		}
	}
	
	/*
	//게시글 목록 전체 조회 테스트
	//게시물 갯수 몇개인지 출력하고, 게시글 모든 내용을 toString()으로 출력하세요.
	@Test
	public void getListTest() {
		List<BoardVO> list = mapper.getArticleList();
		System.out.println(list.size());
		for(BoardVO vo : list) {
			System.out.println(vo); //.toString 붙이지 않아도 자동으로 됨. lombok
		}		
	}
	*/

	//게시물 단일 조회 테스트
	//44번글을 조회해서 글 상세 내용을 출력해 주세요.
	@Test
	public void getArticleTest() {
		BoardVO vo = mapper.getArticle(44);
		System.out.println(vo.getContent());
	}
	
	//게시글 수정 테스트
	//BoardVO 객체를 하나 생성하고, VO의 setter를 사용하여
	//수정 내용(글 제목, 글 내용)을 입력하고 수정을 진행해 보세요. (1번글의 제목, 내용)
	@Test
	public void updateTest() {
		BoardVO vo = new BoardVO();
		vo.setBoardNo(1);
		vo.setTitle("수정될 제목 수정수정");
		vo.setContent("수정입니다. 수정이에요. 내용 수정수정");
		mapper.update(vo);
		System.out.println("수정 후 정보: " + mapper.getArticle(1));
	}
	
	//게시글 삭제 테스트
	//3번글을 삭제하세요. 삭제 후 상세보기를 통해 3번글을 가져왔을 때 null이 리턴되는지
	//조건문으로 확인해서 결과를 출력하세요. (null이 왔다는 것 -> 삭제 성공! 게시글 없음!)
	@Test
	public void deleteTest() {
		mapper.delete(3);
		if(mapper.getArticle(3) == null) { //조회 결과가 없으면 0이 온다.(myBatis)
			System.out.println("삭제 성공! 게시글 없음!");
		} else {
			System.out.println("삭제 실패 ㅠㅠ");
		}
	}
	
}