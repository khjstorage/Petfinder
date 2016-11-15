package com.petfinder.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.petfinder.vo.MemberVO;
/**
 * 회원정보 CRUD 요청을 처리하는 비즈니스 인터페이스
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
public interface MemberService {
	public List<MemberVO> getMember(String sessionId) throws Exception;
	public void insertMember(MemberVO memberVO, HttpServletRequest request) throws Exception;
	public void updateMember(MemberVO memberVO, HttpServletRequest requesr) throws Exception;
	public void deleteMember(String id);
	public String loginMember(HashMap<String, String> map);
}


