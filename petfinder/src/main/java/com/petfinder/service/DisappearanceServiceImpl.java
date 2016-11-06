package com.petfinder.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.petfinder.dao.DisappearanceDAO;
import com.petfinder.vo.DisappearanceVO;

@Service("disappearanceService")
public class DisappearanceServiceImpl implements DisappearanceService {
	
	@Resource(name="disappearanceDAO")
	private DisappearanceDAO disappearanceDAO;

	@Override
	public ArrayList<DisappearanceVO> getDisapprance() {
		System.out.println("Service test");
		disappearanceDAO.getDisappr();
		return null;
	}

	@Override
	public void insertDisapprance(DisappearanceVO disappearanceVO) {
		disappearanceDAO.insertDisappr(disappearanceVO);
	}

	@Override
	public void updateDisapprance(String name) {
		
	}

	@Override
	public void deleteDisapprance(String name) {
		
	}


}
