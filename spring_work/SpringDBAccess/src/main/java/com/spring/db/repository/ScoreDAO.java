package com.spring.db.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.db.model.ScoreVO;

@Repository
public class ScoreDAO implements IScoreDAO {

	//내부(중첩) 클래스 (inner class)
	//두 클래스가 굉장히 긴밀한 관계가 있을 때 주로 선언.
	//해당 클래스 안에서만 사용할 클래스를 굳이 새 파일을 만들지 않고도 선언이 가능.
	class ScoreMapper implements RowMapper<ScoreVO> {

		@Override
		public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {

			ScoreVO vo = new ScoreVO();
			vo.setStuId(rs.getInt("stu_id"));
			vo.setStuName(rs.getString("stu_name"));
			vo.setKor(rs.getInt("kor"));
			vo.setEng(rs.getInt("eng"));
			vo.setMath(rs.getInt("math"));
			vo.setTotal(rs.getInt("total"));
			vo.setAverage(rs.getDouble("average"));

			return vo;
		}

	}

	//# Spring-jdbc 방식의 처리: JdbcTemplate 사용!
	@Autowired
	private JdbcTemplate template;

	@Override
	public void insertScore(ScoreVO score) {
		String sql = "INSERT INTO scores VALUES(id_seq.NEXTVAL,?,?,?,?,?,?)";

		template.update(sql, score.getStuName(), score.getKor(), score.getEng(), score.getMath()
				, score.getTotal(), score.getAverage());
	}

	@Override
	public List<ScoreVO> selectAllscores() {

		String sql = "SELECT * FROM scores ORDER BY stu_id ASC";
		return template.query(sql, (rs, rowNum) -> {
			ScoreVO vo = new ScoreVO();
			vo.setStuId(rs.getInt("stu_id"));
			vo.setStuName(rs.getString("stu_name"));
			vo.setKor(rs.getInt("kor"));
			vo.setEng(rs.getInt("eng"));
			vo.setMath(rs.getInt("math"));
			vo.setTotal(rs.getInt("total"));
			vo.setAverage(rs.getDouble("average"));

			return vo;
		});
	}

	@Override
	public void deleteScore(int num) {
		String sql = "DELETE FROM scores WHERE stu_id=?";
		template.update(sql, num);
	}

	@Override
	public ScoreVO selectOne(int num) {
		String sql = "SELECT * FROM scores WHERE stu_id=?";
		try {				
			return template.queryForObject(sql, new ScoreMapper(), num);
		} catch (Exception e) {
			return null;
		}
	}

}