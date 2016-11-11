package com.petfinder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.petfinder.dao.FindsDAO;
import com.petfinder.utill.FindsFileUtils;
import com.petfinder.vo.DisappearanceVO;
import com.petfinder.vo.FindsVO;


@Service("findsService")
public class FindsServiceImpl implements FindsService{
	
	@Resource(name="findsFileUtils")
	private FindsFileUtils findsFileUtils;
	
	@Resource(name="findsDAO")
	private FindsDAO findsDAO;

	@Override
	public List<FindsVO> findsList() {
		return findsDAO.findsList();
	}

	@Override
	public void insertFinds(FindsVO findsVO, HttpServletRequest request) throws Exception {
		findsDAO.insertFinds(findsVO);
		Map<String,Object> mapFile = findsFileUtils.parseInsertFileInfo(findsVO, request);
		findsDAO.insertFindsFile(mapFile);
		
	}

	@Override
	public Map<String, Object> selectBoardDetail(String parameter) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		
		Map<String, Object> map = findsDAO.selectBoardDetail(parameter);
		resultMap.put("infoMap", map);
		
		List<Object> fileMap = findsDAO.selectBoardDetailFile(parameter);
		resultMap.put("fileMap", fileMap);

		return resultMap;
	}
	
	@Override
	public void updateFinds(FindsVO findsVO, HttpServletRequest request) throws Exception {
		findsDAO.updateFinds(findsVO);
		Map<String, Object> mapFile = findsFileUtils.parseInsertFileInfo(findsVO, request);
		findsDAO.updateFindsFile(mapFile);
	}
	
	@Override
	public void deleteFinds(String idx) {
		findsDAO.deleteFindsFile(idx);
		findsDAO.deleteFinds(idx);
	}
	
	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
	    return findsDAO.selectFileInfo(map);
	}
	
	
	@Override
	public List<DisappearanceVO> searchFinds(FindsVO findsVO) throws Exception{
		return findsDAO.searchFinds(findsVO);
	}
}
