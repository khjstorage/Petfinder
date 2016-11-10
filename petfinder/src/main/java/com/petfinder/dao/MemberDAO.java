package com.petfinder.dao;

import java.util.HashMap;
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
		sqlSession.insert("member.insertmember", memberVO);
	}

	public void insertFile(Map<String,Object> mapFile) {
		sqlSession.insert("member.insertfile", mapFile);
	}

	public List<MemberVO> getMember(String sessionId) {
		return sqlSession.selectList("member.getmember", sessionId);
	}

	public List<MemberVO> getID(String id, String pwd){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		return sqlSession.selectList("member.getid", map);
	}



}
