package com.petfinder.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petfinder.service.DisappearanceService;

@Controller
public class DisapperanceController {

    @Resource(name="disappearanceService")
    private DisappearanceService disappearanceService;
	
	@RequestMapping("/disappearance_list")
	public String disappearance_list() {
		System.out.println("Controller test");
		disappearanceService.getDisappr();
		return "/disappearance_list";
	}
}
