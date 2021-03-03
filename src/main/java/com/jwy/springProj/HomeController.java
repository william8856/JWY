package com.jwy.springProj;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static String uploadPath = "E:\\lecture\\springupload";
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String ajaxTest() {
		return "testJson";
	}
	
	@RequestMapping(value="/uploadForm", method=RequestMethod.GET)
	public void uploadForm() {
		
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/uploadForm", method=RequestMethod.POST)
	public String uploadForm(HttpServletRequest request, MultipartFile uploadFile, Model model) throws IOException {
		System.out.println("업로드 파일 이름 : " + uploadFile.getOriginalFilename());
		System.out.println("파일 사이즈 : " + uploadFile.getSize());
		System.out.println("업로드 파일의 타입 : " + uploadFile.getContentType());  // 파일 MIME type
		
		String uploadFileName = uploadFile(request, uploadFile.getOriginalFilename(), uploadFile.getBytes());  // DB로
		
		System.out.println(request.getRealPath("resources/uploads"));
		// 서비스 단 호출
		
		model.addAttribute("saveFileName", uploadFileName);
		
		return "uploadResult";
	}

	private String uploadFile(HttpServletRequest request, String originalFilename, byte[] file) throws IOException {
		// UUID : Universal Unique ID
		UUID uuid = UUID.randomUUID();
		
		String saveName = uuid.toString() + "_" + originalFilename;
		System.out.println("완성된 파일 이름 : " + saveName);
		
		String path = request.getSession().getServletContext().getRealPath("resources/uploads");
		System.out.println(path);
		
		File target = new File(request.getRealPath("resources/uploads"), saveName);
		FileCopyUtils.copy(file, target);  // 복사
		return saveName;
	}
}
