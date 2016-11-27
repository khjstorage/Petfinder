package com.petfinder.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.petfinder.vo.MemberVO;
/**
 * �쉶�썝�젙蹂� CRUD �슂泥��쓣 泥섎━�븯�뒗 鍮꾩쫰�땲�뒪 �씤�꽣�럹�씠�뒪
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
public interface MemberService {
	
	public List<MemberVO> getMember(String sessionId) throws Exception;
	
	/**
	 * �븘�씠�뵒 �뙣�뒪�썙�뱶 �솗�씤 �슂泥��쓣 泥섎━�븯湲� �쐞�빐 �뜲�씠�꽣泥섎━瑜� �슂泥��븳�떎.
	 * 
	 * @param HashMap<String, String> map / id, pwd
	 * @return String
	 * @throws 
	 */
	public String loginMember(HashMap<String, String> map);
	
	public void insertMember(MemberVO memberVO, HttpServletRequest request) throws Exception;
	
	public void updateMember(MemberVO memberVO, HttpServletRequest requesr) throws Exception;
	
	public void deleteMember(String id);
	
	public List<MemberVO> duplication(String duplicationId);


}


