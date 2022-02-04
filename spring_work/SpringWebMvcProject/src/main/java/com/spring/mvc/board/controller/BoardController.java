package com.spring.mvc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.service.IBoardService;

@Controller
@RequestMapping("/board") //공통 url mapping
public class BoardController {
	
	@Autowired //bean 주입
	private IBoardService service;
	
	//게시글 목록 불러오기 요청
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("/board/list: GET");
		model.addAttribute("articles", service.getArticleList());
		
		return "board/list";
	}
	
	//글쓰기 페이지로 이동 요청
	@GetMapping("/write")
	public void write() { //파일명이 url이랑 같으니까 void
		System.out.println("/board/write: GET");
	}
	
	//게시글 DB 등록 요청
	@PostMapping("/write")
	public String write(BoardVO article) {
		System.out.println("/board/write: POST");
		service.insert(article);
		
		return "redirect:/board/list";
	}
	
	//게시글 상세보기 요청
	@GetMapping("/content/{boardNo}")
//	public String content(@RequestParam("boardNo") int boardNo, Model model) {
	//파라미터값과 변수명이 동일하면 @RequestParam 생략 가능
//	public String content(@PathVariable("boardNo") int boardNo, Model model) {
	//@PathVariable은 URL 경로에 변수를 포함시켜 주는 방식
	//null이나 공백이 들어갈 수 있는 파라미터라면 적용하지 않는 것을 추천.
	//파라미터값에 .이 포함되어 있으면 .뒤의 값은 잘린다.
	//{} 안에 변수명을 지어주시고, @PathVariable 괄호 안에 영역을 지목해서
	//값을 받아온다.
	public String content(@PathVariable int boardNo, Model model) { //변수 이름이 같으면 () 생략 가능
		System.out.println("/board/content: GET");
		System.out.println("요청된 글 번호: " + boardNo);
		model.addAttribute("article", service.getArticle(boardNo));
		return "board/content";
	}
	
	//게시글 수정 화면 요청
	@GetMapping("/modify")
	public void modify(int boardNo, Model model) {
		System.out.println("/board/modify: GET");
		model.addAttribute("article", service.getArticle(boardNo));
	}
	
	//게시글 수정 요청
	@PostMapping("/modify")
	public String modify(BoardVO article) {
		System.out.println("/board/modify: POST");
		service.update(article);
		
		return "redirect:/board/content/" + article.getBoardNo();
	}
	
	//게시글 삭제 처리 요청
	@PostMapping("/delete") //삭제는 post방식이 원칙
//	public String remove(@RequestParam("boardNo") int boardNo) {
	public String remove(int boardNo, RedirectAttributes ra) {
		System.out.println("/board/delete: POST");
		service.delete(boardNo);
		ra.addFlashAttribute("msg", "delSuccess");
		
		return "redirect:/board/list";
	}
	
}