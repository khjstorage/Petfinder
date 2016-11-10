package com.petfinder.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petfinder.service.FindsService;
import com.petfinder.vo.FindsVO;

@Controller
public class FindsController {

	@Resource(name = "findsService")
	private FindsService findsService;

	@RequestMapping("/finds_list")
	public ModelAndView finds_list(@ModelAttribute("findsVO") FindsVO findsVO) {
		ModelAndView mv = new ModelAndView();
		List<FindsVO> list = findsService.findsList(findsVO);
		mv.addObject("findslist", list);
		mv.setViewName("finds/finds_list");
		return mv;
	}

	@RequestMapping("/finds_form")
	public String finds_form() {
		return "finds/finds_form";
	}

	@RequestMapping("/finds_write")
	public String finds_write(@ModelAttribute("findsVO") FindsVO findsVO,
			HttpServletRequest request) throws Exception {
		findsService.insertFinds(findsVO, request);
		return "redirect:finds_list.do";
	}

	@RequestMapping("/finds_contents")
	public ModelAndView finds_contents(HttpServletRequest request)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = findsService.selectBoardDetail(request
				.getParameter("idx"));
		mv.addObject("map", map);
		mv.setViewName("finds/finds_contents");
		return mv;
	}
	
	@RequestMapping("/finds_delete")
	public String finds_delete(@RequestParam("idx") String idx){
		findsService.deleteFinds(idx);
		return "redirect:finds_list.do";
	}
}
