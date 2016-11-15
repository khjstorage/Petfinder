package com.petfinder.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petfinder.vo.DisappearanceVO;
import com.petfinder.vo.FindsVO;
/**
 * 발견정보에 관한 데이터처리 DAO 클래스
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
@Repository("findsDAO")
public class FindsDAO {

	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * DB에 발견글을 (입력)한다.
	 * 
	 * @param FindsVO findsVO
	 * @return void
	 * @throws 
	 */
	public void insertFinds(FindsVO findsVO){
		sqlSession.insert("finds.insertFinds", findsVO);
	}

	/**
	 * DB에 발견글사진을 (입력)한다.
	 * 
	 * @param Map<String,Object> map
	 * @return void
	 * @throws 
	 */
	public void insertFindsFile(Map<String,Object> map){
		sqlSession.insert("finds.insertFindsFile", map);
	}
	
	/**
	 * DB에서 발견글목록을 (조회) 한다.
	 * 
	 * @param 
	 * @return List<DisappearanceVO>
	 * @throws Exception
	 */
	public List<FindsVO> findsList() {
		return sqlSession.selectList("finds.findsList");
	}
	
	/**
	 * DB에서 발견글을 (상세조회) 한다.
	 * 
	 * @param String parameter
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	public Map<String, Object> selectBoardDetail(String parameter){
		return sqlSession.selectOne("finds.selectBoardDetail", parameter);
	}

	/**
	 * DB에서 발견글사진을 (상세조회) 한다.
	 * 
	 * @param String parameter
	 * @return List<Object>
	 * @throws Exception
	 */
	public List<Object> selectBoardDetailFile(String parameter){
		return sqlSession.selectList("finds.selectBoardDetailFile", parameter);
	}
	
	/**
	 * DB에서 발견글을 (삭제) 한다.
	 * 
	 * @param String idx
	 * @return void
	 * @throws Exception
	 */
	public void deleteFinds(String idx) {
		sqlSession.delete("finds.deleteFinds", idx);
	}
	
	/**
	 * DB에서 발견글사진을 (삭제) 한다.
	 * 
	 * @param String idx
	 * @return void
	 * @throws Exception
	 */
	public void deleteFindsFile(String idx) {
		sqlSession.delete("finds.deleteFindsFile", idx);
	}

	/**
	 * DB에서 발견글을 (수정) 한다.
	 * 
	 * @param FindsVO findsVO
	 * @return void
	 * @throws Exception
	 */
	public void updateFinds(FindsVO findsVO) {
		sqlSession.update("finds.updateFinds", findsVO);
	}

	/**
	 * DB에서 발견글사진을 (수정) 한다.
	 * 
	 * @param String pIdx
	 * @return Map<String, Object> mapFile
	 * @throws Exception
	 */
	public void updateFindsFile(Map<String, Object> mapFile) {
		sqlSession.update("finds.updateFindsFile", mapFile);
	}
	
	/**
	 * DB에서 발견게시판 상세글과 실종게시판 상세글과 일치 하는 데이터 (조회) 한다.
	 * 
	 * @param DisappearanceVO disappearanceVO
	 * @return List<FindsVO>
	 * @throws Exception
	 */
	public List<DisappearanceVO> matchFinds(FindsVO findsVO){
		return sqlSession.selectList("disappearance.matchDisappearance", findsVO);
	}
	
	/**
	 * DB에서 발견글사진을 (조회) 한다. 다운로드에 필요한컬럼
	 * 
	 * @param String idx
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	public Map<String, Object> selectFileInfo(String idx) throws Exception{
	    return sqlSession.selectOne("finds.selectFileInfo", idx);
	}

	/**
	 * DB에서 입력한 내용을 (조회) 한다.
	 * 
	 * @param HashMap<String, String> map
	 * @return List<DisappearanceVO>
	 * @throws Exception
	 */
	public List<FindsVO> searchFinds(HashMap<String, String> map){
		return sqlSession.selectList("finds.searchFinds", map);
	}
	
	
	
	public String getPwd(HashMap<String, String> map) {
		return sqlSession.selectOne("finds.getpassword", map);
	}

}
