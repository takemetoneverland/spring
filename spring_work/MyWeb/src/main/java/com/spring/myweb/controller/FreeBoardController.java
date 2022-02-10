package com.spring.myweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.myweb.freeboard.service.IFreeBoardService;

@Controller
@RequestMapping("/freeboard")
public class FreeBoardController {

	@Autowired
	private IFreeBoardService service;
	
}
















