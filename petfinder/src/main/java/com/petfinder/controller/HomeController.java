package com.petfinder.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.petfinder.service.DisappearanceService;
import com.petfinder.service.FindsService;
import com.petfinder.vo.DisappearanceVO;
import com.petfinder.vo.FindsVO;

@Controller
public class HomeController {
	
	@Resource(name = "findsService")
	private FindsService findsService;
	
    @Resource(name="disappearanceService")
    private DisappearanceService disappearanceService;
    
	@RequestMapping("/main.do")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		List<DisappearanceVO> dlist = disappearanceService.disappearanceList();
		mv.addObject("dlist", dlist);
		List<FindsVO> flist = findsService.findsList();
		mv.addObject("flist", flist);
		mv.setViewName("/main");
		return mv;
	}

	@RequestMapping("/login.do")
	public String login() {
		return "/login";
	}


	@RequestMapping("/signup_form.do")
	public String signup_write() {
		return "/signup_form";
	}


	@RequestMapping("/about.do")
	public String about() {
		return "etc/about";
	}


}
