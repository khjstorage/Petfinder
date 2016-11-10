package com.petfinder.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petfinder.vo.FindsVO;

@Repository("findsDAO")
public class FindsDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public void insertFinds(FindsVO findsVO){
		sqlSession.insert("finds.insertFinds", findsVO);
	}

	public List<FindsVO> findsList(FindsVO findsVO) {
		return sqlSession.selectList("finds.findsList", findsVO);
	}
	
	public void insertFindsFile(Map<String,Object> map){
		sqlSession.insert("finds.insertFindsFile", map);
	}

	public Map<String, Object> selectBoardDetail(String parameter) {
		return sqlSession.selectOne("finds.selectBoardDetail", parameter);
	}

	public List<Object> selectBoardDetailFile(String parameter) {
		return sqlSession.selectList("finds.selectBoardDetailFile", parameter);
	}
	
	public void deleteFindsFile(String idx) {
		sqlSession.delete("finds.deleteFindsFile", idx);
	}

	public void deleteFinds(String idx) {
		sqlSession.delete("finds.deleteFinds", idx);
	}


	
	
}
