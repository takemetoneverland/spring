package com.spring.myweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myweb.command.FreeBoardVO;
import com.spring.myweb.freeboard.service.IFreeBoardService;
import com.spring.myweb.util.PageCreator;
import com.spring.myweb.util.PageVO;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {

	@Autowired
	private IFreeBoardService service;
	
	//목록 화면
	@GetMapping("/freeList")
	public String freeList(PageVO vo, Model model) {
		
		System.out.println("검색어: " + vo.getKeyword());
		System.out.println("검색조건: " + vo.getCondition());
		
		PageCreator pc = new PageCreator();
		pc.setPaging(vo);
		pc.setArticleTotalCount(service.getTotal(vo));
		
		System.out.println(pc);
		
		model.addAttribute("boardList", service.getList(vo));
		model.addAttribute("pc", pc);
		
		return "freeBoard/freeList";
		
	}
	
	//글쓰기 화면 처리
	@GetMapping("/freeRegist")
	public void freeRegist() {}

	//글 등록 처리
	@PostMapping("/registForm")
	public String registForm(FreeBoardVO vo, RedirectAttributes ra) {
		service.regist(vo);
		
		ra.addFlashAttribute("msg", "정상 등록 처리 되었습니다.");
		
		return "redirect:/freeBoard/freeList";
	}
	
	//글 상세보기 처리
	@GetMapping("/freeDetail")
	public void getContent(int bno, @ModelAttribute("p") PageVO vo,
							Model model) {
		model.addAttribute("article", service.getContent(bno));
	}
	
	//글 수정 페이지 이동 처리
	@GetMapping("/freeModify")
	public void freeModify(int bno, Model model) {
		model.addAttribute("article", service.getContent(bno));
	}
	
	//글 수정 처리
	@PostMapping("/freeUpdate")
	public String update(FreeBoardVO vo, RedirectAttributes ra) {
		service.update(vo);
		ra.addFlashAttribute("msg", "updateSuccess");
		
		return "redirect:/freeBoard/freeDetail?bno=" + vo.getBno();
	}
	
	//글 삭제 처리
	@PostMapping("/freeDelete")
	public String freeDelete(FreeBoardVO vo, RedirectAttributes ra) {
		service.delete(vo.getBno());
		
		ra.addFlashAttribute("msg", "게시글이 정상 삭제 되었습니다.");
		return "redirect:/freeBoard/freeList";
	}
}