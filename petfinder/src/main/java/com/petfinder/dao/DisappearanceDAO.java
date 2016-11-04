package com.petfinder.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petfinder.vo.DisappearanceVO;

@Repository("disappearanceDAO")
public class DisappearanceDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insertDisappr(DisappearanceVO disappearanceVO) {
		System.out.println("test");
		//sqlSession.insert("sample.insertdisappr", disappearanceVO);
	}
	
	public ArrayList<DisappearanceVO> getDisappr(){
		System.out.println("DAO test");
		return null;
	}

}
