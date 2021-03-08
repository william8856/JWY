package com.jwy.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jwy.domain.BoardVO;

public class TestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("********* Test Interceptor ************");
		System.out.println("호출 방식 : " + request.getMethod());
		System.out.println("호출된 URI : " + request.getRequestURI());
		System.out.println("접속된 세션 : " + request.getSession().getId());
		
		return true;  // true를 반환하면 다음 Interceptor나 대상 컨트롤러를 호출하게 됨
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		Map<String, Object> modelMap = modelAndView.getModel();
		List<BoardVO> lst = (List<BoardVO>) modelMap.get("boardList");
		System.out.println(lst.toString());
		
		System.out.println("**** Test Interceptor (컨트롤러 다녀옴) ****");
	}
}
