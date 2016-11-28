package com.petfinder.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petfinder.service.DisappearanceService;
import com.petfinder.vo.DisappearanceVO;
import com.petfinder.vo.FindsVO;
/**
 * 遺꾩떎�젙蹂� CRUD �슂泥��쓣 泥섎━�븯�뒗 Controller �겢�옒�뒪
 * 
 * @author  1議�
 * @since 2016.11.14
 * @version 1.0
 * @see 
 * <pre>
 *  == 媛쒖젙�씠�젰(Modification Information) ==
 *   
 *      �닔�젙�씪       		   	�닔�젙�옄     		      �닔�젙�궡�슜
 *  ----------------    ------------    ---------------------------
 *   2016.11.14     		1議�             		理쒖큹 �깮�꽦
 *   2016.11.17				源��쁽吏�	  		requestmapping �닔�젙
 * </pre>
 */
@Controller
@RequestMapping("/disappearance")
public class DisapperanceController {

    @Resource(name="disappearanceService")
    private DisappearanceService disappearanceService;
	    
	/** 
	 * 遺꾩떎紐⑸줉�쓣 議고쉶 �븳�떎.
	 * @return List<DisappearanceVO> list
	 * @return "disappearance/disappearancelist"
	 * @throws 
	 */
	@RequestMapping("/list.do")
	public ModelAndView disappearanceList() {
		ModelAndView mv = new ModelAndView();
		List<DisappearanceVO> list = disappearanceService.disappearanceList();
		mv.addObject("disappearancelist", list);
		mv.setViewName("/disappearance/list");
		return mv;
	}

	
	/**
	 * 遺꾩떎�젙蹂� �긽�꽭�솕硫댁쑝濡� �씠�룞�븳�떎. 
	 * 濡쒓렇�씤�맂媛�(�꽭�뀡)怨� 寃뚯떆臾쇱쓽 id媛� �떎瑜대㈃ �닔�젙/�궘�젣 踰꾪듉 鍮꾪솢�꽦
	 * �씪移섑븯硫� idcheck �궎�뿉 permission 媛믪쓣 �꽔�뒗�떎
	 * @param @RequestParam("idx") String idx
	 * @param HttpSession session
	 * @return Map<String,Object> map 
	 * @return "disappearance/disappearance_contents"
	 * @throws Exception
	 */
	@RequestMapping("/contents.do")
	public ModelAndView disappearanceContents(HttpSession session, @RequestParam("idx") String idx) throws Exception {
		String id = (String)session.getAttribute("id");
		String idcheck = disappearanceService.idCheck(idx);
		if(idcheck.equals(id)){
			session.setAttribute("idcheck", "permission");
		}
		ModelAndView mv = new ModelAndView();
		Map<String,Object> map = disappearanceService.selectBoardDetail(idx);
		mv.addObject("map", map.get("infoMap"));
		mv.addObject("file", map.get("fileMap"));;
		mv.setViewName("/disappearance/contents");
		return mv;
	}
			
	
	/**
	 * 遺꾩떎寃뚯떆�뙋 湲��벐湲� �솕硫댁쑝濡� �씠�룞�븳�떎.
	 * @param HttpSession session
	 * @return "disappearance/disappearance_form";
	 * @return "redirect:login.do";
	 * @throws Exception
	 */
	@RequestMapping("/write.do")
	public String disappearanceWrite(HttpSession session) {
		if(session.getAttribute("id")!=null){
			return "/disappearance/write";
		}else{
			return "redirect:/member/login.do";
		}
	}
		
		
	/**
	 * 遺꾩떎�젙蹂� �벑濡앺븯怨� 紐⑸줉議고쉶 �솕硫댁쑝濡� �씠�룞�븳�떎.
	 * @param @ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO 遺꾩떎�젙蹂�
	 * @param HttpServletRequest request �뙆�씪�젙蹂�
	 * @return "redirect:disappearancelist.do";
	 * @throws Exception
	 */
	@RequestMapping("/create.do")
	public String disappearanceCreate(@ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception {
		disappearanceService.insertDisappearance(disappearanceVO, request);
		return "redirect:/disappearance/list.do";
	}
	

	
	/**
	 * 遺꾩떎�젙蹂� �궘�젣 �썑 紐⑸줉議고쉶 �솕硫댁쑝濡� �씠�룞�븳�떎.
	 * @param @RequestParam("idx") String idx
	 * @return "redirect:disappearancelist.do"
	 * @throws Exception
	 */
	@RequestMapping("/delete.do")
	public String disappearanceDelete(@RequestParam("idx") String idx) {
		disappearanceService.deleteDisappearance(idx);
		return "redirect:/disappearance/list.do";
	}
	
	
	
	/**
	 * 遺꾩떎�젙蹂� �닔�젙 �솕硫댁쑝濡� �씠�룞�븳�떎.
	 * �꽭�뀡id�옉 寃뚯떆湲��쓽 id媛� �떎瑜대㈃ �닔�젙�럹�씠吏�濡� 紐산컧(媛뺤젣�쟻�쑝濡� url 蹂�寃�)
	 * @param @RequestParam("idx") String idx
	 * @return Map<String,Object> map 
	 * @return "disappearance/disappearance_update"
	 * @throws Exception
	 */
	@RequestMapping("/edit.do")
	public ModelAndView disappearanceEdit(HttpSession session, @RequestParam("idx") String idx) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> map = disappearanceService.selectBoardDetail(idx);
		Map<String,Object> infoMap = (Map<String, Object>) map.get("infoMap");
		
		if(session.getAttribute("id").equals(infoMap.get("D_ID"))){
			mv.addObject("map", map);
			mv.setViewName("/disappearance/edit");
		}else{
			mv.setViewName("redirect:/disappearance/list.do");
		}
		return mv;
	}
	
	
	
	/** 
	 * 遺꾩떎�젙蹂� �닔�젙�븯怨� 紐⑸줉議고쉶 �솕硫댁쑝濡� �씠�룞�븳�떎.
	 * @param @ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO
	 * @param HttpServletRequest request
	 * @return "redirect:disappearancelist.do"
	 * @throws Exception
	 */
	@RequestMapping("/update.do")
	public String disappearanceUpdate(@ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception {
		disappearanceService.updateDisappearance(disappearanceVO, request);
		return "redirect:/disappearance/list.do";
	}
	
	
	
	/** 
	 * 遺꾩떎湲��쓽 留ㅼ묶踰꾪듉�쓣 �겢由��븯硫� �떎醫낃� �젙蹂댁� �씪移섑븳 寃뚯떆湲� �솕硫댁쑝濡� �씠�룞�븳�떎.
	 * @param @ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO
	 * @param HttpServletRequest request
	 * @return List<FindsVO> list
	 * @return "finds/finds_list"
	 * @throws Exception
	 */
	@RequestMapping("/match.do")
	public ModelAndView disappearanceMatch(@ModelAttribute("disappearanceVO")DisappearanceVO disappearanceVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<FindsVO> list = disappearanceService.matchDisappearance(disappearanceVO);
		mv.addObject("findslist", list);
		mv.setViewName("finds/list");
		return mv;
	}
	
	/** 
	 * �뙆�씪 �떎�슫濡쒕뱶
	 * @param1 @RequestParam("idx") String idx
	 * @param2 HttpServletResponse response
	 * @throws Exception
	 */
	@RequestMapping("/download.do")
	public void disappearanceDownload(@RequestParam("idx") String idx, HttpServletResponse response) throws Exception{
		Map<String, Object> map = disappearanceService.selectFileInfo(idx);
	    String storedFileName = (String)map.get("D_STORED_FILE_NAME");
	    String originalFileName = (String)map.get("D_ORIGINAL_FILE_NAME");
	     
	    byte fileByte[] = FileUtils.readFileToByteArray(new File("C:\\dev\\image\\disappearancefile\\"+storedFileName));
	     
	    response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	     
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	}
	

	/** 
	 * 議고쉶湲곕뒫
	 * @param @RequestParam("keyWord_search") String keyWord_search
	 * @param @RequestParam("selection_search") String selection_search)
	 * @return mv.addObject("disappearancelist", list)
	 * @return mv.setViewName("disappearance/disappearancelist")
	 * @throws Exception
	 */
	@RequestMapping("/search.do")
	public ModelAndView disappearanceSearch(@RequestParam("keyWord_search") String keyWord_search,	@RequestParam("selection_search") String selection_search) throws Exception {
		ModelAndView mv = new ModelAndView();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("keyWord_search", keyWord_search);
		map.put("selection_search", selection_search);
		List<DisappearanceVO> list = disappearanceService.searchDisappearance(map);
		mv.addObject("disappearancelist", list);
		mv.setViewName("/disappearance/list");
		return mv;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
