package com.jwy.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jwy.domain.UserVO;
import com.jwy.dto.LoginDTO;
import com.jwy.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO dao;

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

}
