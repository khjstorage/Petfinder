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
	public void updateDisappearance(DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception {
		disappearanceDAO.updateDisappearance(disappearanceVO);
        Map<String,Object> mapFile = disappearanceFileUtils.parseInsertFileInfo(disappearanceVO, request);
        System.out.println(mapFile.get("D_BOARD_IDX"));
        System.out.println(mapFile.get("D_ORIGINAL_FILE_NAME"));
        System.out.println(mapFile.get("D_STORED_FILE_NAME"));
        System.out.println(mapFile.get("D_FILE_SIZE"));
        disappearanceDAO.updateDisappearanceFile(mapFile);
	}

	@Override
	public void deleteDisappearance(String idx) {
		disappearanceDAO.deleteDisappearanceFile(idx);
		disappearanceDAO.deleteDisappearance(idx);
	}



}
