package com.spring.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.model.ScoreVO;
import com.spring.db.repository.IScoreMapper;

@Service
public class ScoreService implements IScoreService {
	
	//서비스 계층과 DAO 계층 사이의 의존성 자동 주입을 위해 변수를 선언.
//	@Autowired
//	private IScoreDAO dao;
	
	//MyBatis를 이용한 SQL 처리
	@Autowired
	private IScoreMapper mapper;

	@Override
	public void insertScore(ScoreVO score) {
		score.calcData(); //총점, 평균을 구하자
		mapper.insertScore(score);
	}

	@Override
	public List<ScoreVO> selectAllscores() {
		return mapper.selectAllscores();
	}

	@Override
	public void deleteScore(int num) {
		mapper.deleteScore(num);
	}

	@Override
	public ScoreVO selectOne(int num) {
		return mapper.selectOne(num);
	}

}
