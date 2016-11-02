package com.petfinder.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;


@Repository("memberDao")
public class MemberDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insertMember(Model model) {
		sqlSession.insert("com.petfinder.dao.MemberDao.insertmember", model);
	}
	
	

}
