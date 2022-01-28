package com.spring.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.model.BoardVO;
import com.spring.db.repository.IBoardMapper;

@Service
public class BoardService implements IBoardService {
	
//	@Autowired
//	private IBoardDAO dao;
	
	@Autowired
	private IBoardMapper mapper;

	@Override
	public void insertArticle(BoardVO vo) {
		mapper.insertArticle(vo);
	}

	@Override
	public List<BoardVO> getArticles() {
		return mapper.getArticles();
	}

	@Override
	public BoardVO getArticle(int bId) {
		return mapper.getArticle(bId);
	}

	@Override
	public void deleteArticle(int bId) {
		mapper.deleteArticle(bId);
	}

	@Override
	public void updateArticle(BoardVO vo) {
		mapper.updateArticle(vo);		
	}
	
	@Override
	public List<BoardVO> searchList(String keyword) {
		keyword = "%" + keyword + "%";
		return mapper.searchList(keyword);
	}

}
