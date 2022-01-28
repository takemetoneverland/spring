package com.spring.db.repository;

import java.util.List;

import com.spring.db.model.ScoreVO;

public interface IScoreMapper { //IScoreMapper는 DAO를 대체해서 만든 것이다. (MyBatis)
	
	//점수 등록 기능
	void insertScore(ScoreVO score);
	
	//점수 전체 조회 기능
	List<ScoreVO> selectAllscores();
	
	//점수 삭제 기능
	void deleteScore(int num);
	
	//점수 개별 조회 기능
	ScoreVO selectOne(int num);

}
