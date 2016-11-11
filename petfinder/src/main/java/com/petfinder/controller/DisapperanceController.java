package com.petfinder.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petfinder.service.DisappearanceService;
import com.petfinder.vo.DisappearanceVO;
import com.petfinder.vo.FindsVO;

@Controller
public class DisapperanceController {

    @Resource(name="disappearanceService")
    private DisappearanceService disappearanceService;
	
	@RequestMapping("/disappearance_list")
	public ModelAndView disappearance_list() {
		ModelAndView mv = new ModelAndView();
		List<DisappearanceVO> list = disappearanceService.disappearanceList();
		mv.addObject("disappearancelist", list);
		mv.setViewName("disappearance/disappearance_list");
		return mv;
	}
	
	@RequestMapping("/disappearance_form")
	public String disappearance_form(HttpSession session) {
		if(session.getAttribute("id")!=null){
			return "disappearance/disappearance_form";
		}else{
			return "redirect:login.do";
		}
	}
	
	@RequestMapping("/disappearance_write")
	public String disappearance_write(@ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception {
		disappearanceService.insertDisappearance(disappearanceVO, request);
		return "redirect:disappearance_list.do";
	}
	
	@RequestMapping("/disappearance_contents")
	public ModelAndView disappearance_contents(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> map = disappearanceService.selectBoardDetail(request.getParameter("idx"));
		mv.addObject("map", map.get("infoMap"));
		mv.addObject("file", map.get("fileMap"));;
		mv.setViewName("disappearance/disappearance_contents");
		return mv;
	}
	
	@RequestMapping("/disappearance_delete")
	public String disappearance_delete(@RequestParam("idx") String idx) {
		disappearanceService.deleteDisappearance(idx);
		return "redirect:disappearance_list.do";
	}
	
	@RequestMapping("/disappearance_update")
	public ModelAndView disappearance_update(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> map = disappearanceService.selectBoardDetail(request.getParameter("idx"));
		mv.addObject("map", map);
		mv.setViewName("disappearance/disappearance_update");
		return mv;
	}

	@RequestMapping("/disappearance_update_pro")
	public String disappearance_update_pro(@ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception {
		disappearanceService.updateDisappearance(disappearanceVO, request);
		return "redirect:disappearance_list.do";
	}
	
	@RequestMapping("/disappearance_search")
	public ModelAndView disappearance_search(@ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<FindsVO> list = disappearanceService.searchDisappearance(disappearanceVO);
		mv.addObject("findslist", list);
		mv.setViewName("finds/finds_list");
		return mv;
	}
}
