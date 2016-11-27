package com.petfinder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.petfinder.dao.MemberDAO;
import com.petfinder.utill.MemberFileUtils;
import com.petfinder.vo.MemberVO;
/**
 * �쉶�썝�젙蹂� CRUD �슂泥��쓣 泥섎━�븯�뒗 鍮꾩쫰�땲�뒪 �겢�옒�뒪
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
@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource(name="memberfileUtils")
	private MemberFileUtils memberfileUtils;

	@Resource(name="memberDao")
	private MemberDAO memberDao;

	
	/**
	 * �븘�씠�뵒 �뙣�뒪�썙�뱶 �솗�씤 �슂泥��쓣 泥섎━�븯湲� �쐞�빐 �뜲�씠�꽣泥섎━瑜� �슂泥��븳�떎.
	 * 
	 * @param HashMap<String, String> map / id, pwd
	 * @return String
	 * @throws 
	 */
	@Override
	public List<MemberVO> loginMember(HashMap<String, String> map){
		return memberDao.loginMember(map);
	}

	@Override
	public List<MemberVO> getMember(String sessionId) throws Exception {
		return memberDao.getMember(sessionId);
	}
	
	@Override
	public void insertMember(MemberVO memberVO, HttpServletRequest request) throws Exception {
		memberDao.insertMember(memberVO);
		Map<String,Object> mapFile = memberfileUtils.parseInsertFileInfo(memberVO, request);
		if(mapFile!=null){
			memberDao.insertFile(mapFile);
		}
	}


	@Override
	public void updateMember(MemberVO memberVO, HttpServletRequest request) throws Exception{
		memberDao.updateMember(memberVO);
		Map<String,Object> mapFile = memberfileUtils.parseInsertFileInfo(memberVO, request);
		if(mapFile!=null){
			memberDao.updateMemberFile(mapFile);
		}
	}

	@Override
	public void deleteMember(String id){
		memberDao.deleteMemberFile(id);
		memberDao.deleteMember(id);
	}

	@Override
	public List<MemberVO> duplication(String duplicationId) {
		return memberDao.duplication(duplicationId);
	}


}
