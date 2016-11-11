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

	public List<MemberVO> getID(HashMap<String, String> map){
		return sqlSession.selectList("member.getid", map);
	}

	public void deleteMember(String id){
		sqlSession.delete("member.deletemember", id);
	}
	
	public void deleteMemberFile(String id){
		sqlSession.delete("member.deletememberfile",id);
	}
	
	public void updateMember(MemberVO memberVO){
		sqlSession.update("member.updateMember", memberVO);
	}
	
	public void updateMemberFile(Map<String, Object> mapFile){
		sqlSession.update("member.updateMemberFile", mapFile);
	}


}
