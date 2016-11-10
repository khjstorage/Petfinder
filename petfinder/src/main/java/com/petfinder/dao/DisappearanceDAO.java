package com.petfinder.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petfinder.vo.DisappearanceVO;

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
	
	public List<DisappearanceVO> disappearanceList(DisappearanceVO disappearanceVO){
		return sqlSession.selectList("disappearance.disappearanceList", disappearanceVO);
	}

	public Map<String, Object> selectBoardDetail(String parameter) {
		return sqlSession.selectOne("disappearance.selectBoardDetail", parameter);
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

}
