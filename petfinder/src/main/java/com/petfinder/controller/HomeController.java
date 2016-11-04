package com.petfinder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	//메인화면 이동
	@RequestMapping("/main")
	public String main() {
		return "/main";
	}

	//로그인 이동
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}
	
	@RequestMapping("/login_pro")
	public String login_pro(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpSession session) {
		System.out.println(id + pwd);
		return "redirect:main.do";
	}

	//발견게시물 이동
	@RequestMapping("/finds_list")
	public String finds_list() {
		return "/finds_list";
	}

	//가입게시판
	@RequestMapping("/signup_form")
	public String signup_write() {
		return "/signup_form";
	}

	//마이페이지 이동
	@RequestMapping("/mypage")
	public String mypage() {
		return "/mypage";
	}

	//어바웃페이지 이동
	@RequestMapping("/about")
	public String about() {
		return "/about";
	}


}
