package com.petfinder.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petfinder.vo.DisappearanceVO;
import com.petfinder.vo.FindsVO;

@Repository("disappearanceDAO")
public class DisappearanceDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insertDisappearance(DisappearanceVO disappearanceVO) {
		sqlSession.insert("disappearance.insertDisappearance", disappearanceVO);
	}
	
	public void insertDisappearanceFile(Map<String,Object> mapFile) {
		sqlSession.insert("disappearance.insertDisappearanceFile", mapFile);
	}
	
	public List<DisappearanceVO> disappearanceList(){
		return sqlSession.selectList("disappearance.disappearanceList");
	}

	public Map<String, Object> selectBoardDetail(String parameter) {
		return sqlSession.selectOne("disappearance.selectBoardDetail", parameter);
	}

	public List<Object> selectBoardDetailFile(String parameter){
		return sqlSession.selectList("disappearance.selectBoardDetailFile", parameter);
	}
	
	public void deleteDisappearanceFile(String idx) {
		sqlSession.delete("disappearance.deleteDisappearanceFile", idx);
	}
	
	public void deleteDisappearance(String idx) {
		sqlSession.delete("disappearance.deleteDisappearance", idx);
	}

	public void updateDisappearance(DisappearanceVO disappearanceVO) {
		sqlSession.update("disappearance.updateDisappearance", disappearanceVO);
	}

	public void updateDisappearanceFile(Map<String, Object> mapFile) {
		sqlSession.update("disappearance.updateDisappearanceFile", mapFile);
	}
	
	public List<FindsVO> searchDisappearance(DisappearanceVO disappearanceVO){
		return sqlSession.selectList("finds.searchFinds",disappearanceVO);
	}

}
