package com.petfinder.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.petfinder.dao.FindsDAO;
import com.petfinder.utill.FindsFileUtils;
import com.petfinder.vo.FindsVO;


@Service("findsService")
public class FindsServiceImpl implements FindsService{
	
	@Resource(name="findsFileUtils")
	private FindsFileUtils findsFileUtils;
	
	@Resource(name="findsDAO")
	private FindsDAO findsDAO;

	@Override
	public List<FindsVO> findsList(FindsVO findsVO) {
		return findsDAO.findsList(null);
	}

	@Override
	public void insertFinds(FindsVO findsVO, HttpServletRequest request) throws Exception {
		findsDAO.insertFinds(findsVO);
		Map<String,Object> mapFile = findsFileUtils.parseInsertFileInfo(findsVO, request);
		findsDAO.insertFindsFile(mapFile);
		
	}

	@Override
	public Map<String, Object> selectBoardDetail(String parameter) throws Exception {
		Map<String, Object> resultMap = findsDAO.selectBoardDetail(parameter);
		
		
		System.out.println(resultMap.get(parameter));
		
		List<Object> list = findsDAO.selectBoardDetailFile(parameter);
		resultMap.put("list", list);
		
		/*findsDAO.selectBoardDetailFile(parameter);*/
		
		return resultMap;
	}
	
	@Override
	public void deleteFinds(String idx) {
		findsDAO.deleteFindsFile(idx);
		findsDAO.deleteFinds(idx);
	}
}
