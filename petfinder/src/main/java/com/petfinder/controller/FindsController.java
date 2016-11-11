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

import com.petfinder.command.CommandMap;
import com.petfinder.service.FindsService;
import com.petfinder.vo.DisappearanceVO;
import com.petfinder.vo.FindsVO;

@Controller
public class FindsController {

	@Resource(name = "findsService")
	private FindsService findsService;

	@RequestMapping("/finds_list")
	public ModelAndView finds_list() {
		ModelAndView mv = new ModelAndView();
		List<FindsVO> list = findsService.findsList();
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
	public ModelAndView finds_contents(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = findsService.selectBoardDetail(request.getParameter("idx"));
		mv.addObject("map", map.get("infoMap"));
		mv.addObject("file", map.get("fileMap"));
		mv.setViewName("finds/finds_contents");
		return mv;
	}
	
	@RequestMapping("/finds_delete")
	public String finds_delete(@RequestParam("idx") String idx){
		findsService.deleteFinds(idx);
		return "redirect:finds_list.do";
	}
	
	@RequestMapping("/finds_update")
	public ModelAndView finds_update(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = findsService.selectBoardDetail(request.getParameter("idx"));
		mv.addObject("map", map);
		mv.setViewName("finds/finds_update");
		return mv;
	}
	
	@RequestMapping("/finds_update_pro")
	public String finds_update_pro(@ModelAttribute("findsVO")FindsVO findsVO, HttpServletRequest request) throws Exception {
		findsService.updateFinds(findsVO, request);
		return "redirect:finds_list.do";
	}
	
	// 다운로드 수정
//	@RequestMapping("/downloadFile")
//	public void downloadFile(CommandMap commandMap, HttpServletResponse response) throws Exception{
//	    Map<String,Object> map = findsService.selectFileInfo(commandMap.getMap());
//	    String storedFileName = (String)map.get("F_STORED_FILE_NAME");
//	    String originalFileName = (String)map.get("F_ORIGINAL_FILE_NAME");
//	     
//	    byte fileByte[] = FileUtils.readFileToByteArray(new File("C:\\dev\\findsfile\\"+storedFileName));
//	     
//	    response.setContentType("application/octet-stream");
//	    response.setContentLength(fileByte.length);
//	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
//	    response.setHeader("Content-Transfer-Encoding", "binary");
//	    response.getOutputStream().write(fileByte);
//	     
//	    response.getOutputStream().flush();
//	    response.getOutputStream().close();
//	}
	
	@RequestMapping("/finds_search")
	public ModelAndView finds_search(@ModelAttribute("findsVO")FindsVO findsVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<DisappearanceVO> list = findsService.searchFinds(findsVO);
		mv.addObject("disappearancelist", list);
		mv.setViewName("disappearance/disappearance_list");
		return mv;
	}
	
}
