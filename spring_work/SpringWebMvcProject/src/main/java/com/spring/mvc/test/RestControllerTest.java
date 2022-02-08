package com.spring.mvc.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestControllerTest {
	
	/*
	 @ResponseBody
	 - 리턴 데이터를 viewResolver에게 전달하지 않고
	 클라이언트에게 해당 데이터를 바로 응답하게 한다.
	 비동기 통신에서 주로 많이 사용한다.
	 - @RestController를 사용하면 모든 메서드에
	 @ResponseBody를 붙인 결과와 같다.
	 */

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello World!";
	}
	
	@GetMapping("/hobby")
//	@ResponseBody
	public List<String> hobby() {
		List<String> hobby = Arrays.asList("축구", "수영", "영화감상");
		return hobby;
	}
	
	@GetMapping("/study")
	public Map<String, Object> study() {
		
		Map<String, Object> subject = new HashMap<>();
		subject.put("자바", "java");
		subject.put("jsp", "java server pages");
		subject.put("spring", "spring frameworks");
		
		return subject;
	}
	
	@GetMapping("/person")
	public Person person() {
		Person p = new Person();
		p.setName("김철수");
		p.setAge(30);
		p.setHobbies(Arrays.asList("수영", "독서", "축구"));
		
		return p;
	}
	
	@GetMapping(value="/getText", produces = "text/plain") //produces = "application/json" 생략 가능함
	public String getText() {
		System.out.println("/getText 요청이 들어옴!");
		return "Hello World!";
	}
	
	@PostMapping("/getObject")
	public Person getObject(@RequestBody Person person) {
		System.out.println("/getObject 요청이 들어옴!");
		System.out.println("이름: " + person.getName());
		System.out.println("나이: " + person.getAge());
		System.out.println("취미: " + person.getHobbies());

		person.setAge(40);

		return person;
		
	}
	
	@GetMapping("/getPath/{id}/{cpp}/{page}")
	public Map<String, Object> getPath(@PathVariable int id,
									   @PathVariable int cpp, 
									   @PathVariable int page) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("아이디", id);
		map.put("게시글갯수", cpp);
		map.put("페이지번호", page);
		
		return map;
	}
	
}












