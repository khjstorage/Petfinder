package com.petfinder.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petfinder.service.FindsService;

@Controller
public class FindsController {

    @Resource(name="findsService")
    private FindsService findsService;
    
	@RequestMapping("/finds_list.do")
	public String finds_list() {
		return "finds/finds_list";
	}

}
