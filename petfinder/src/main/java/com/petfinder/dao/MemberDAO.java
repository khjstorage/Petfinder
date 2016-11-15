package com.petfinder.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petfinder.vo.MemberVO;
/**
 * 회원정보에 관한 데이터처리 DAO 클래스
 * 
 * @author  1조
 * @since 2016.11.14
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *   
 *          수정일          수정자           수정내용
 *  ----------------    ------------    ---------------------------
 *   2016.11.14        1조             최초 생성
 * 
 * </pre>
 */
@Repository("memberDao")
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	/**
	 * DB에 회원정보를 (입력)한다.
	 * 
	 * @param MemberVO memberVO
	 * @return void
	 * @throws 
	 */
	public void insertMember(MemberVO memberVO) {
		sqlSession.insert("member.insertmember", memberVO);
	}

	/**
	 * DB에 회원사진을 (입력)한다.
	 * 
	 * @param MemberVO memberVO
	 * @return void
	 * @throws 
	 */
	public void insertFile(Map<String,Object> mapFile) {
		sqlSession.insert("member.insertfile", mapFile);
	}

	/**
	 * DB에 회원정보를 (입력)한다.
	 * 
	 * @param MemberVO memberVO
	 * @return void
	 * @throws 
	 */
	public List<MemberVO> getMember(String sessionId) {
		return sqlSession.selectList("member.getmember", sessionId);
	}

	/**
	 * DB에 회원아이디를 (조회) 한다
	 * 
	 * @param HashMap<String, String> map 아아디, 패스워드
	 * @return List<MemberVO>
	 * @throws 
	 */
	public List<MemberVO> getID(HashMap<String, String> map){
		return sqlSession.selectList("member.getid", map);
	}

	/**
	 * DB에 회원아이디를 (삭제) 한다
	 * 
	 * @param String id
	 * @return 
	 * @throws 
	 */
	public void deleteMember(String id){
		sqlSession.delete("member.deletemember", id);
	}
	
	/**
	 * DB에 회원사진을 (삭제) 한다
	 * 
	 * @param String id
	 * @return 
	 * @throws 
	 */
	public void deleteMemberFile(String id){
		sqlSession.delete("member.deletememberfile",id);
	}
	
	/**
	 * DB에 회원정보를 (수정) 한다
	 * 
	 * @param MemberVO memberVO
	 * @return 
	 * @throws 
	 */
	public void updateMember(MemberVO memberVO){
		sqlSession.update("member.updateMember", memberVO);
	}

	/**
	 * DB에 회원사진을 (수정) 한다
	 * 
	 * @param Map<String, Object> mapFile
	 * @return 
	 * @throws 
	 */
	public void updateMemberFile(Map<String, Object> mapFile){
		sqlSession.update("member.updateMemberFile", mapFile);
	}


}
