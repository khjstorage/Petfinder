package com.petfinder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.petfinder.dao.DisappearanceDAO;
import com.petfinder.utill.DisappearanceFileUtils;
import com.petfinder.vo.DisappearanceVO;
import com.petfinder.vo.FindsVO;

@Service("disappearanceService")
public class DisappearanceServiceImpl implements DisappearanceService {
	
    @Resource(name="disappearanceFileUtils")
    private DisappearanceFileUtils disappearanceFileUtils;
	
	@Resource(name="disappearanceDAO")
	private DisappearanceDAO disappearanceDAO;

	@Override
	public List<DisappearanceVO> disappearanceList() {
		return disappearanceDAO.disappearanceList();
	}


	@Override
	public Map<String, Object> selectBoardDetail(String parameter)throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		
		Map<String, Object> map = disappearanceDAO.selectBoardDetail(parameter);
		resultMap.put("infoMap", map);
		
		List<Object> fileMap = disappearanceDAO.selectBoardDetailFile(parameter);
		resultMap.put("fileMap", fileMap);
	    
	    return resultMap;
	}
	
	
	@Override
	public void insertDisappearance(DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception {
		disappearanceDAO.insertDisappearance(disappearanceVO);
        Map<String,Object> mapFile = disappearanceFileUtils.parseInsertFileInfo(disappearanceVO, request);
        disappearanceDAO.insertDisappearanceFile(mapFile);
	}

	@Override
	public void updateDisappearance(DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception {
		disappearanceDAO.updateDisappearance(disappearanceVO);
        Map<String,Object> mapFile = disappearanceFileUtils.parseInsertFileInfo(disappearanceVO, request);
        disappearanceDAO.updateDisappearanceFile(mapFile);
	}

	@Override
	public void deleteDisappearance(String idx) {
		disappearanceDAO.deleteDisappearanceFile(idx);
		disappearanceDAO.deleteDisappearance(idx);
	}
	
	@Override
	public List<FindsVO> searchDisappearance(DisappearanceVO disappearanceVO){
		return disappearanceDAO.searchDisappearance(disappearanceVO);
	}



}
