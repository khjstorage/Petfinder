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
	public void updateDisappr(String name) {
		
	}

	@Override
	public void deleteDisappr(String name) {
		
	}

	@Override
	public ArrayList<DisappearanceVO> getDisappr() {
		System.out.println("Service test");
		disappearanceDAO.getDisappr();
		return null;
	}

	@Override
	public void insertDisappr(DisappearanceVO disappearanceVO) {
		disappearanceDAO.insertDisappr(disappearanceVO);
	}

}
