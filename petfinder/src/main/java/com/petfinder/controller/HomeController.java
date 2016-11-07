package com.petfinder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petfinder.vo.MemberVO;

@Controller
public class HomeController {

	@RequestMapping("/main.do")
	public String main() {
		return "/main";
	}

	@RequestMapping("/login.do")
	public String login() {
		return "/login";
	}
	
	@RequestMapping("/login_process.do")
	public ModelAndView login_pro(MemberVO memberVO, @RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:main.do");
		return mv;
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
