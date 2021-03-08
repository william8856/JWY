package com.jwy.service;

import com.jwy.domain.UserVO;
import com.jwy.dto.LoginDTO;

public interface UserService {
	public UserVO login(LoginDTO dto) throws Exception;
}
