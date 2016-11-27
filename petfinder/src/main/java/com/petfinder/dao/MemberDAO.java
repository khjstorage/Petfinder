package com.petfinder.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petfinder.vo.MemberVO;
/**
 * �쉶�썝�젙蹂댁뿉 愿��븳 �뜲�씠�꽣泥섎━ DAO �겢�옒�뒪
 * 
 * @author  1議�
 * @since 2016.11.14
 * @version 1.0
 * @see <pre>
 *  == 媛쒖젙�씠�젰(Modification Information) ==
 *   
 *          �닔�젙�씪          �닔�젙�옄           �닔�젙�궡�슜
 *  ----------------    ------------    ---------------------------
 *   2016.11.14        1議�             理쒖큹 �깮�꽦
 * 
 * </pre>
 */
@Repository("memberDao")
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	/**
	 * DB�뿉 �쉶�썝�젙蹂대�� (�엯�젰)�븳�떎.
	 * 
	 * @param MemberVO memberVO
	 * @return void
	 * @throws 
	 */
	public void insertMember(MemberVO memberVO) {
		sqlSession.insert("member.insertmember", memberVO);
	}

	/**
	 * DB�뿉 �쉶�썝�궗吏꾩쓣 (�엯�젰)�븳�떎.
	 * 
	 * @param MemberVO memberVO
	 * @return void
	 * @throws 
	 */
	public void insertFile(Map<String,Object> mapFile) {
		sqlSession.insert("member.insertfile", mapFile);
	}

	/**
	 * DB�뿉 �쉶�썝�젙蹂대�� (�엯�젰)�븳�떎.
	 * 
	 * @param MemberVO memberVO
	 * @return void
	 * @throws 
	 */
	public List<MemberVO> getMember(String sessionId) {
		return sqlSession.selectList("member.getmember", sessionId);
	}

	/**
	 * DB�뿉 �쉶�썝�븘�씠�뵒瑜� (議고쉶) �븳�떎
	 * 
	 * @param HashMap<String, String> map �븘�븘�뵒, �뙣�뒪�썙�뱶
	 * @return List<MemberVO>
	 * @throws 
	 */
	public List<MemberVO> loginMember(HashMap<String, String> map){
		return sqlSession.selectList("member.loginmember", map);
	}

	/**
	 * DB�뿉 �쉶�썝�븘�씠�뵒瑜� (�궘�젣) �븳�떎
	 * 
	 * @param String id
	 * @return 
	 * @throws 
	 */
	public void deleteMember(String id){
		sqlSession.delete("member.deletemember", id);
	}
	
	/**
	 * DB�뿉 �쉶�썝�궗吏꾩쓣 (�궘�젣) �븳�떎
	 * 
	 * @param String id
	 * @return 
	 * @throws 
	 */
	public void deleteMemberFile(String id){
		sqlSession.delete("member.deletememberfile",id);
	}
	
	/**
	 * DB�뿉 �쉶�썝�젙蹂대�� (�닔�젙) �븳�떎
	 * 
	 * @param MemberVO memberVO
	 * @return 
	 * @throws 
	 */
	public void updateMember(MemberVO memberVO){
		sqlSession.update("member.updateMember", memberVO);
	}

	/**
	 * DB�뿉 �쉶�썝�궗吏꾩쓣 (�닔�젙) �븳�떎
	 * 
	 * @param Map<String, Object> mapFile
	 * @return 
	 * @throws 
	 */
	public void updateMemberFile(Map<String, Object> mapFile){
		sqlSession.update("member.updateMemberFile", mapFile);
	}

	public List<MemberVO> duplication(String duplicationId){
		return sqlSession.selectList("member.duplication", duplicationId);
	}

}
