package com.jwy.springProj;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwy.domain.ReplyVO;
import com.jwy.service.ReplyService;

@RestController  // 이 클래스가 REST방식의 컨트롤러임을 컴파일러에게 전달
@RequestMapping("/replies")
public class ReplyController {
	@Inject
	private ReplyService service;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO vo) {
		System.out.println("");
		
		ResponseEntity<String> entity = null;
		
		try {
			service.addReply(vo);
			entity = new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
