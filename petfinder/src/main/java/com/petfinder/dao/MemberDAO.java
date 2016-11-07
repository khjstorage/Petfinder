package com.petfinder.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petfinder.vo.MemberVO;

@Repository("memberDao")
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insertMember(MemberVO memberVO) {
		sqlSession.insert("sample.insertmember", memberVO);
	}
	
	public void insertFile(Map<String,Object> mapFile) {
		sqlSession.insert("sample.insertfile", mapFile);
	}

	public List<MemberVO> getMember(MemberVO memberVO) {
		return sqlSession.selectList("sample.getmember", memberVO);
	}
	
}
