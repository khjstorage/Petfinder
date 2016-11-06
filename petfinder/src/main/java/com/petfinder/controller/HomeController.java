package com.petfinder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String login_pro(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpSession session) {
		System.out.println(id + pwd);
		return "redirect:main.do";
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
