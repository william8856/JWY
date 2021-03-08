package com.jwy.springProj;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jwy.domain.UserVO;
import com.jwy.dto.LoginDTO;
import com.jwy.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Inject
	private UserService service;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public void login() {
		
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public void login(LoginDTO dto, HttpSession session, Model model) throws Exception {
		UserVO vo = service.login(dto);
		System.out.println(vo.toString());
		
		if(vo == null) {
			return;
		}
		
		model.addAttribute("loginMember", vo);
	}
}
