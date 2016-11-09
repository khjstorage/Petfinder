package com.petfinder.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.petfinder.dao.DisappearanceDAO;
import com.petfinder.utill.DisappearanceFileUtils;
import com.petfinder.vo.DisappearanceVO;

@Service("disappearanceService")
public class DisappearanceServiceImpl implements DisappearanceService {
	
    @Resource(name="disappearanceFileUtils")
    private DisappearanceFileUtils disappearanceFileUtils;
	
	@Resource(name="disappearanceDAO")
	private DisappearanceDAO disappearanceDAO;

	@Override
	public List<DisappearanceVO> disappearanceList(DisappearanceVO disappearanceVO) {
		return disappearanceDAO.disappearanceList(null);
	}


	@Override
	public Map<String, Object> selectBoardDetail(String parameter)throws Exception {
	    Map<String, Object> resultMap = disappearanceDAO.selectBoardDetail(parameter);
	    return resultMap;
	}
	
	
	@Override
	public void insertDisappearance(DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception {
		disappearanceDAO.insertDisappearance(disappearanceVO);
        Map<String,Object> mapFile = disappearanceFileUtils.parseInsertFileInfo(disappearanceVO, request);
        disappearanceDAO.insertDisappearanceFile(mapFile);
	}

	@Override
	public void updateDisappearance(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDisappearance(String name) {
		// TODO Auto-generated method stub
		
	}



}
