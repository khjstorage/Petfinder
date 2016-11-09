package com.petfinder.utill;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.petfinder.vo.DisappearanceVO;

@Component("disappearanceFileUtils")
public class DisappearanceFileUtils {
	private static final String filePath = "C:\\dev\\disappearancefile\\";

	public Map<String,Object> parseInsertFileInfo(DisappearanceVO disappearanceVO, HttpServletRequest request) throws Exception{
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		Map<String, Object> mapFile = null;
		
		String boardidx = disappearanceVO.getIdx();
		File file = new File(filePath);
		
		if(file.exists() == false){
			file.mkdirs();
		}

		while(iterator.hasNext()){
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false){
				
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = CommonUtils.getRandomString() + originalFileExtension;
				
				file = new File(filePath + storedFileName);
				multipartFile.transferTo(file);
				
				mapFile = new HashMap<String,Object>();
				mapFile.put("D_BOARD_IDX", boardidx);
				mapFile.put("D_ORIGINAL_FILE_NAME", originalFileName);
				mapFile.put("D_STORED_FILE_NAME", storedFileName);
				mapFile.put("D_FILE_SIZE", multipartFile.getSize());

			}else{
				
			}
		}
		return mapFile;
	}
}