package com.petfinder.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petfinder.service.MemberService;

@Controller
public class HomeController {
	

    @Resource(name="memberService")
    private MemberService memberService;
	
	@RequestMapping("/main")
	public String main() {
		return "/main";
	}
	
	@RequestMapping("/signup_form")
	public String signup_write() {
		return "/signup_form";
	}
	
	@RequestMapping("/signup")
	public String signup(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		memberService.insertMember(model);
		return "redirect:main";
	}	

}
