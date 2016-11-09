package com.petfinder.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.petfinder.service.DisappearanceService;
import com.petfinder.vo.DisappearanceVO;

@Controller
public class DisapperanceController {

    @Resource(name="disappearanceService")
    private DisappearanceService disappearanceService;
	
	@RequestMapping("/disappearance_list")
	public ModelAndView disappearance_list(@ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO) {
		ModelAndView mv = new ModelAndView();
		List<DisappearanceVO> list = disappearanceService.disappearanceList(disappearanceVO);
		mv.addObject("disappearancelist", list);
		mv.setViewName("disappearance/disappearance_list");
		return mv;
	}
	
	@RequestMapping("/disappearance_form")
	public String disappearance_form() {
		return "disappearance/disappearance_form";
	}
	
	@RequestMapping("/disappearance_write")
	public String disappearance_write(@ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception {
		disappearanceService.insertDisappearance(disappearanceVO, request);
		return "redirect:disappearance_list.do";
	}
	
	@RequestMapping("/disappearance_contents")
	public String disappearance_contents() throws Exception {
		return "disappearance/disappearance_contents";
	}
}
