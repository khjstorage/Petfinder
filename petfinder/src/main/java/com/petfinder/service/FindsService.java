package com.petfinder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.petfinder.vo.DisappearanceVO;
import com.petfinder.vo.FindsVO;
import com.petfinder.vo.PagingVO;
/**
 * 발견정보 CRUD 요청을 처리하는 비즈니스 인터페이스
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
public interface FindsService {

	/**
	 * 발견게시판 (리스트) 요청을 처리하기 위해 데이터처리를 요청한다.
	 * 
	 * @param 
	 * @return List
	 * @throws 
	 */
	public List<FindsVO> findsList();
	
	/**
	 * 발견게시판 (상세글) 요청을 처리하기 위해 데이터처리를 요청한다.
	 * 
	 * @param String parameter
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	public Map<String, Object> selectBoardDetail(String parameter) throws Exception;
	
	/**
	 * 발견게시판 (입력) 요청을 처리하기 위해 데이터처리를 요청한다.
	 * 
	 * @param FindsVO findsVO, HttpServletRequest request
	 * @return 
	 * @throws Exception
	 */
	public void insertFinds(FindsVO findsVO, HttpServletRequest request) throws Exception;
	
	/**
	 * 발견게시판 (수정) 요청을 처리하기 위해 데이터처리를 요청한다.
	 * 
	 * @param FindsVO findsVO, HttpServletRequest request
	 * @return 
	 * @throws Exception
	 */
	public void updateFinds(FindsVO findsVO, HttpServletRequest request) throws Exception;
	
	/**
	 * 발견게시판 (삭제) 요청을 처리하기 위해 데이터처리를 요청한다.
	 * 
	 * @param String pIdx
	 * @return 
	 * @throws 
	 */
	public void deleteFinds(String idx);
	
	/**
	 * 발견게시판 상세글과 실종게시판 상세글과 일치 하는 데이터 (조회) 요청을 처리하기 위해 데이터처리를 요청한다.
	 * 
	 * @param FindsVO findsVO
	 * @return List<DisappearanceVO>
	 * @throws 
	 */
	public List<DisappearanceVO> matchFinds(FindsVO findsVO) throws Exception;
	
	/**
	 * 발견게시판 사진다운로드를 처리하기 위해 데이터처리를 요청한다.
	 * 
	 * @param String idx
	 * @return Map<String, Object>
	 * @throws 
	 */
	public Map<String, Object> selectFileInfo(String idx) throws Exception;

	
	/** 
	 * 작성된 글을 조회하기 위해 데이터처리를 요청한다.
	 * 
	 * @param HashMap<String, String> map
	 * @return List<FindsVO>
	 * @throws 
	 */
	public List<FindsVO> searchFinds(HashMap<String, String> map);
	
	public String passwordAuth(HashMap<String, String> map);

	public int postCount();

	public List<PagingVO> getBoardList(PagingVO pagingVO);

}
